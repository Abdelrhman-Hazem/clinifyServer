package gov.iti.jets.clinify.mappers;

import gov.iti.jets.clinify.models.dtos.ClinicSimpleDto;
import gov.iti.jets.clinify.models.entities.Clinic;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface ClinicSimpleMapper {
    Clinic toEntity(ClinicSimpleDto clinicSimpleDto);

    ClinicSimpleDto toDto(Clinic clinic);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Clinic partialUpdate(ClinicSimpleDto clinicSimpleDto, @MappingTarget Clinic clinic);
}