package gov.iti.jets.clinify.mappers;

import gov.iti.jets.clinify.mappers.DoctorSimpleMapper;
import gov.iti.jets.clinify.mappers.PatientSimpleMapper;
import gov.iti.jets.clinify.models.dtos.AppointmentWithoutRatingDto;
import gov.iti.jets.clinify.models.entities.Appointment;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING, uses = {DoctorSimpleMapper.class, PatientSimpleMapper.class})
public interface AppointmentWithoutRatingMapper {
    Appointment toEntity(AppointmentWithoutRatingDto appointmentWithoutRatingDto);

    AppointmentWithoutRatingDto toDto(Appointment appointment);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Appointment partialUpdate(AppointmentWithoutRatingDto appointmentWithoutRatingDto, @MappingTarget Appointment appointment);
}