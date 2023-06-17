package gov.iti.jets.clinify.mappers;

import gov.iti.jets.clinify.models.dtos.DoctorDto;
import gov.iti.jets.clinify.models.entities.Doctor;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING, uses = {DoctorTitleSimpleMapper.class, ClinicSimpleMapper.class, DoctorSpecializationSimpleMapper.class, AppointmentWithoutRatingMapper.class})
public interface DoctorMapper {
    Doctor toEntity(DoctorDto doctorDto);

    @AfterMapping
    default void linkAppointments(@MappingTarget Doctor doctor) {
        doctor.getAppointments().forEach(appointment -> appointment.setDoctor(doctor));
    }

    DoctorDto toDto(Doctor doctor);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Doctor partialUpdate(DoctorDto doctorDto, @MappingTarget Doctor doctor);
}