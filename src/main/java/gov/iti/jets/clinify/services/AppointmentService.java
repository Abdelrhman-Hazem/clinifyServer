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
import java.util.Optional;
import java.util.Set;

@AllArgsConstructor
@Service
public class AppointmentService extends BaseServiceImp<Appointment, AppointmentDto>{


    private final AppointmentRepository appointmentRepository;

    @Override
    public BaseRepository<Appointment> Repository() {
        return appointmentRepository;
    }

    @Override
    public BaseMapper<Appointment, AppointmentDto> mapper(){
        return Mappers.getMapper(AppointmentMapper.class);
    }

    public List<AppointmentDto> findAllByPatientId(Integer doctorId){
        return mapper().toDtos(appointmentRepository.findAllByPatient_IdOrderByDate(doctorId));
    }

//    public List<AppointmentDto> findAllByDoctorId(Integer doctorId){
//        return mapper().toDtos(appointmentRepository.findAllByDoctor_Id(doctorId));
//    }
//
//    public List<AppointmentDto> findAllUpcomingByDoctorId(Integer doctorId){
//        return mapper().toDtos(appointmentRepository.findAllByDoctor_IdAndDateGreaterThan(doctorId, new Timestamp(System.currentTimeMillis())));
//    }
        public void cancelPatientAppointment(Integer id) {
        Optional<Appointment> appointmentOptional = appointmentRepository.findById(id);
        
        if (appointmentOptional.isPresent()) {
            Appointment appointment = appointmentOptional.get();
            appointment.setPatient(null); 
            appointmentRepository.save(appointment); 
        } else {
            throw new IllegalArgumentException("Appointment not found with id: " + id);
        }
    }

}
