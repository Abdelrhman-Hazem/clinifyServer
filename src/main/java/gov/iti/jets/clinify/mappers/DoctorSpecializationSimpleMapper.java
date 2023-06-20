package gov.iti.jets.clinify.mappers;

import gov.iti.jets.clinify.models.dtos.simpleDto.DoctorSpecializationSimpleDto;
import gov.iti.jets.clinify.models.entities.DoctorSpecialization;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface DoctorSpecializationSimpleMapper {
    DoctorSpecialization toEntity(DoctorSpecializationSimpleDto doctorSpecializationSimpleDto);

    DoctorSpecializationSimpleDto toDto(DoctorSpecialization doctorSpecialization);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    DoctorSpecialization partialUpdate(DoctorSpecializationSimpleDto doctorSpecializationSimpleDto, @MappingTarget DoctorSpecialization doctorSpecialization);
}
