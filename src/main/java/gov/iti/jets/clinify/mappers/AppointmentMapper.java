package gov.iti.jets.clinify.mappers;

import gov.iti.jets.clinify.models.dtos.AppointmentDto;
import gov.iti.jets.clinify.models.dtos.AreaDto;
import gov.iti.jets.clinify.models.entities.Appointment;
import gov.iti.jets.clinify.models.entities.Area;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface AppointmentMapper extends BaseMapper<Appointment, AppointmentDto>{
    Appointment toEntity(AppointmentDto appointmentDto);

    AppointmentDto toDto(Appointment appointment);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Appointment partialUpdate(AppointmentDto appointmentDto, @MappingTarget Appointment appointment);
}
