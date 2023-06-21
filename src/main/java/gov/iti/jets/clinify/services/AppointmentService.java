package gov.iti.jets.clinify.services;

import gov.iti.jets.clinify.mappers.AppointmentMapper;
import gov.iti.jets.clinify.mappers.BaseMapper;
import gov.iti.jets.clinify.models.dtos.AppointmentDto;
import gov.iti.jets.clinify.models.dtos.AppointmentWithoutRatingDto;
import gov.iti.jets.clinify.models.entities.Appointment;
import gov.iti.jets.clinify.repositories.AppointmentRepository;
import gov.iti.jets.clinify.repositories.BaseRepository;
import lombok.AllArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

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

    public List<AppointmentDto> findAllByDoctorId(Integer doctorId){
        return mapper().toDtos(appointmentRepository.findAllByDoctor_Id(doctorId));
    }

    public List<AppointmentDto> findAllUpcomingByDoctorId(Integer doctorId){
        return mapper().toDtos(appointmentRepository.findAllByDoctor_IdAndDateGreaterThan(doctorId, new Timestamp(System.currentTimeMillis())));
    }

}
