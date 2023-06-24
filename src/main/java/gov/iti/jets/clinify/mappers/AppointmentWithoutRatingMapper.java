package gov.iti.jets.clinify.mappers;

import gov.iti.jets.clinify.models.dtos.AppointmentWithoutRatingDto;
import gov.iti.jets.clinify.models.entities.Appointment;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface AppointmentWithoutRatingMapper extends BaseMapper<Appointment, AppointmentWithoutRatingDto>{
    Appointment toEntity(AppointmentWithoutRatingDto appointmentWithoutRatingDto);

    AppointmentWithoutRatingDto toDto(Appointment appointment);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Appointment partialUpdate(AppointmentWithoutRatingDto appointmentWithoutRatingDto, @MappingTarget Appointment appointment);
}
