package gov.iti.jets.clinify.services;

import gov.iti.jets.clinify.exceptions.AppointmentNotSavedException;
import gov.iti.jets.clinify.mappers.AppointmentWithoutRatingMapper;
import gov.iti.jets.clinify.mappers.BaseMapper;
import gov.iti.jets.clinify.models.dtos.AppointmentDto;
import gov.iti.jets.clinify.models.dtos.AppointmentWithoutRatingDto;
import gov.iti.jets.clinify.models.entities.Appointment;
import gov.iti.jets.clinify.models.entities.Doctor;
import gov.iti.jets.clinify.repositories.AppointmentRepository;
import gov.iti.jets.clinify.repositories.BaseRepository;
import gov.iti.jets.clinify.repositories.PatientRepository;
import lombok.AllArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@AllArgsConstructor
@Service
public class AppointmentWithoutRatingService extends BaseServiceImp<Appointment, AppointmentWithoutRatingDto>{

    @Autowired
    private DoctorService doctorService;

    @Autowired
    private PatientRepository patientRepository;
    
    private final AppointmentRepository appointmentRepository;

    @Override
    public BaseRepository<Appointment> Repository() {
        return appointmentRepository;
    }

    @Override
    public BaseMapper<Appointment, AppointmentWithoutRatingDto> mapper(){
        return Mappers.getMapper(AppointmentWithoutRatingMapper.class);
    }


    @Override
    @Transactional(readOnly = false)
    public AppointmentWithoutRatingDto save(AppointmentWithoutRatingDto dto) throws AppointmentNotSavedException {
        updateDateTimestamp(dto);
        validateAppointment(dto);

        return saveChecked(dto);
    }

    @Transactional(readOnly = false)
    public void bookAppointment (Integer appointmentId, Integer patientId) throws AppointmentNotSavedException{
        Appointment appointment = appointmentRepository.findById(appointmentId).get();
        if(appointment.getPatient()!=null) throw new AppointmentNotSavedException("Appointment Already Booked");

        appointment.setPatient(patientRepository.findById(patientId).get());
        appointment.setStatus("Pending");

        appointmentRepository.save(appointment);
    }

    @Transactional(readOnly = false)
    public void rateAppointment (Integer appointmentId, Integer rating) throws AppointmentNotSavedException{
        if(rating<1 || rating>5) throw new AppointmentNotSavedException("Invalid Rating, should be between 1 & 5 stars");

        Appointment appointment = appointmentRepository.findById(appointmentId).get();
        appointment.setRating(rating);

        doctorService.updateRating(appointment.getDoctor(),rating);
        appointmentRepository.save(appointment);
    }

    public AppointmentWithoutRatingDto updateAppointment(AppointmentWithoutRatingDto dto) throws AppointmentNotSavedException{
        updateDateTimestamp(dto);
        validateAppointment(dto);

        Optional<Appointment> appointmentOptional = appointmentRepository.findById(dto.getId());
        System.out.println("--------------------------");
//        if()
//        Appointment appointment = appointmentRepository.findById(dto.getId()).;

        if(appointmentOptional.isPresent()) {
            Appointment appointment = appointmentOptional.get();
            System.out.println("-------------------");
            for (Appointment singleAppointment : appointment.getDividedAppointments()) {
                long singleEndTimeStampInMinutes = singleAppointment.getDate().getTime() / (60 * 100);
                long dtoEndTimeStampInMinutes = dto.getDate().getTime() / (60 * 1000) + getTimeDifference(dto);

                if (singleAppointment.getPatient() != null &&
                        singleAppointment.getDate().compareTo(dto.getDate()) < 0
                        || singleEndTimeStampInMinutes > dtoEndTimeStampInMinutes) {
                    throw new AppointmentNotSavedException("A patient booked an appointment during that time");
                }
            }
        }
        return saveChecked(dto);
    }


    public List<AppointmentWithoutRatingDto> findAllFullByDoctorId(Integer doctorId){
        return mapper().toDtos(appointmentRepository.findAllByDoctor_IdAndFullAppointmentNullOrderByDate(doctorId));
    }

    public List<AppointmentWithoutRatingDto> findAllFullUpcomingByDoctorId(Integer doctorId){
        return mapper().toDtos(appointmentRepository.findAllByDoctor_IdAndDateGreaterThanAndFullAppointmentNullOrderByDate(doctorId, new Timestamp(System.currentTimeMillis())));
    }

    public List<AppointmentWithoutRatingDto> findAllDividedByDoctorId(Integer doctorId){
        return mapper().toDtos(appointmentRepository.findAllByDoctor_IdAndFullAppointmentNotNullAndDoctor_IsDeletedIsFalseOrderByDate(doctorId));
    }

    public List<AppointmentWithoutRatingDto> findAllDividedUpcomingByDoctorId(Integer doctorId){
        return mapper().toDtos(appointmentRepository.findAllByDoctor_IdAndDateGreaterThanAndFullAppointmentNotNullAndDoctor_IsDeletedIsFalseOrderByDate(doctorId, new Timestamp(System.currentTimeMillis())));
    }

    private Timestamp addMinutesToTimestamp(Timestamp timestamp, int minutes){
        System.out.println(minutes);
        System.out.println(timestamp);
        LocalDateTime localDateTime = timestamp.toLocalDateTime();
        System.out.println(localDateTime);
        LocalDateTime newDateTime = localDateTime.plusMinutes(minutes);
        System.out.println(newDateTime);
        System.out.println(Timestamp.valueOf(newDateTime));
        return Timestamp.valueOf(newDateTime);
    }

    private Time addMinutesToTime(Time timestamp, int minutes){
        LocalTime localTime = timestamp.toLocalTime();
        LocalTime newTime = localTime.plusMinutes(minutes);
        return Time.valueOf(newTime);
    }

    private Set<Appointment> createDividedAppointmentSet(AppointmentWithoutRatingDto dto){
        Appointment fullAppointment = mapper().toEntity(dto);
        long timeDifference = getTimeDifference(dto);
        Set<Appointment> dividedAppointments = new HashSet<>();
//        dto.setDoctor(doctorService.findById(dto.getDoctor().getId()));
        for(int i=0;i<timeDifference/dto.getDoctor().getAvgMinutesPerPatient();i++){
            Timestamp date= addMinutesToTimestamp( dto.getDate(), dto.getDoctor().getAvgMinutesPerPatient() * i);
            Time startTime = new Time(date.getTime());
            Time endTime = addMinutesToTime(startTime,dto.getDoctor().getAvgMinutesPerPatient());
            Appointment appointment = new Appointment(doctorService.mapper().toEntity(dto.getDoctor()), date, startTime, endTime);
            appointment.setFullAppointment(fullAppointment);
            appointmentRepository.save(appointment);
            dividedAppointments.add(appointment);
        }
        System.out.println("aaaaaaaaaaaaaaaaaaaaaa");
        return dividedAppointments;
    }


    private AppointmentWithoutRatingDto saveChecked(AppointmentWithoutRatingDto dto){
        Appointment appointment = mapper().toEntity(dto);
        appointment = Repository().save(appointment);
        createDividedAppointmentSet(mapper().toDto(appointment));
        System.out.println("ssssssssssssssssssssssssss");
//        appointment.setDividedAppointments(createDividedAppointmentSet(mapper().toDto(appointment)));
//        System.out.println(appointment);
        return mapper().toDto(appointment);
    }

    private void validateAppointment(AppointmentWithoutRatingDto dto) throws AppointmentNotSavedException{
        long timeDifference = getTimeDifference(dto);
        dto.setDoctor(doctorService.findById(dto.getDoctor().getId()));
        if(timeDifference<dto.getDoctor().getAvgMinutesPerPatient()) throw new AppointmentNotSavedException("Appointment Time Length less than the time for 1 patient");
        if(dto.getDate().getTime()<System.currentTimeMillis()) throw  new AppointmentNotSavedException("Appointment time must be in the future");
    }

    private long getTimeDifference(AppointmentWithoutRatingDto dto){
        long timeDifference = (dto.getEndTime().getTime()-dto.getStartTime().getTime())/(60*1000);
        if(timeDifference<0)timeDifference+=24*60;
        return timeDifference;
    }

    private void updateDateTimestamp(AppointmentWithoutRatingDto dto){
        //Add start time to date timestamp
        dto.setDate(
                addMinutesToTimestamp(dto.getDate(),180+(int)(dto.getStartTime().getTime()/(60*1000)))
        );
        System.out.println("kkkkkkkkkkkkkkkkkkk");
        System.out.println(dto.getStartTime().getTime());
        System.out.println(dto);
    }

}
