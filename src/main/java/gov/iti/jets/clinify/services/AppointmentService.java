package gov.iti.jets.clinify.services;

import gov.iti.jets.clinify.exceptions.AppointmentNotSavedException;
import gov.iti.jets.clinify.mappers.AppointmentMapper;
import gov.iti.jets.clinify.mappers.BaseMapper;
import gov.iti.jets.clinify.models.dtos.AppointmentDto;
import gov.iti.jets.clinify.models.entities.Appointment;
import gov.iti.jets.clinify.repositories.AppointmentRepository;
import gov.iti.jets.clinify.repositories.BaseRepository;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.ObjectUtils;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@Service
public class AppointmentService extends BaseServiceImp<Appointment, AppointmentDto>{

    @Autowired
    private DoctorService doctorService;
    private final AppointmentRepository appointmentRepository;

    @Override
    public BaseRepository<Appointment> Repository() {
        return appointmentRepository;
    }

    @Override
    public BaseMapper<Appointment, AppointmentDto> mapper(){
        return Mappers.getMapper(AppointmentMapper.class);
    }

    private Timestamp addMinutesToTimestamp(Timestamp timestamp, int minutes){
        LocalDateTime localDateTime = timestamp.toLocalDateTime();
        LocalDateTime newDateTime = localDateTime.plusMinutes(minutes);
        return Timestamp.valueOf(newDateTime);
    }

    private Time addMinutesToTime(Time timestamp, int minutes){
        LocalTime localTime = timestamp.toLocalTime();
        LocalTime newTime = localTime.plusMinutes(minutes);
        return Time.valueOf(newTime);
    }

    private Set<Appointment> createDividedAppointmentSet(AppointmentDto dto){
        long timeDifference = getTimeDifference(dto);
        Set<Appointment> dividedAppoinments = null;
        for(int i=0;i<timeDifference/dto.getDoctor().getAvgMinutesPerPatient();i++){
            Timestamp date= addMinutesToTimestamp( dto.getDate(), dto.getDoctor().getAvgMinutesPerPatient() * i);
            Time startTime = new Time(date.getTime());
            Time endTime = addMinutesToTime(startTime,dto.getDoctor().getAvgMinutesPerPatient());
            dividedAppoinments.add(new Appointment(doctorService.mapper().toEntity(dto.getDoctor()), date, startTime, endTime));
        }
        return dividedAppoinments;
    }

    @Override
    @Transactional(readOnly = false)
    public AppointmentDto save(AppointmentDto dto) throws AppointmentNotSavedException {
        updateDateTimestamp(dto);
        validateAppointment(dto);

        return saveChecked(dto);
    }

    private AppointmentDto saveChecked(AppointmentDto dto){
        Appointment appointment = mapper().toEntity(dto);
        appointment.setDividedAppointments(createDividedAppointmentSet(dto));
        return mapper().toDto(Repository().save(appointment));
    }

    private void validateAppointment(AppointmentDto dto) throws AppointmentNotSavedException{
        long timeDifference = getTimeDifference(dto);
        if(timeDifference<dto.getDoctor().getAvgMinutesPerPatient()) throw new AppointmentNotSavedException("Appointment Time Length less than the time for 1 patient");
        if(dto.getDate().getTime()<System.currentTimeMillis()) throw  new AppointmentNotSavedException("Appointment time must be in the future");
    }

    private long getTimeDifference(AppointmentDto dto){
        long timeDifference = (dto.getStartTime().getTime()-dto.getEndTime().getTime())/(60*1000);
        if(timeDifference<0)timeDifference+=24*60;
        return timeDifference;
    }

    private void updateDateTimestamp(AppointmentDto dto){
        //Add start time to date timestamp
        dto.setDate(
                addMinutesToTimestamp(dto.getDate(),(int)(dto.getStartTime().getTime()/(60*1000)))
        );
    }

    public AppointmentDto updateAppointment(AppointmentDto dto) throws AppointmentNotSavedException{
        updateDateTimestamp(dto);
        validateAppointment(dto);

        Appointment appointment = appointmentRepository.findById(dto.getId()).get();
        for(Appointment singleAppointment:appointment.getDividedAppointments()){
            long singleEndTimeStampInMinutes = singleAppointment.getDate().getTime()/(60*100);
            long dtoEndTimeStampInMinutes = dto.getDate().getTime()/(60*1000)+getTimeDifference(dto);

            if(singleAppointment.getPatient()!= null &&
                singleAppointment.getDate().compareTo(dto.getDate()) < 0
                || singleEndTimeStampInMinutes > dtoEndTimeStampInMinutes ){
                    throw new AppointmentNotSavedException("A patient booked an appointment during that time");
            }
        }
        return saveChecked(dto);
    }

    public List<AppointmentDto> findAllByPatientId(Integer doctorId){
        return mapper().toDtos(appointmentRepository.findAllByPatient_Id(doctorId));
    }

    public List<AppointmentDto> findAllByDoctorId(Integer doctorId){
        return mapper().toDtos(appointmentRepository.findAllByDoctor_Id(doctorId));
    }

    public List<AppointmentDto> findAllUpcomingByDoctorId(Integer doctorId){
        return mapper().toDtos(appointmentRepository.findAllByDoctor_IdAndDateGreaterThan(doctorId, new Timestamp(System.currentTimeMillis())));
    }

}
