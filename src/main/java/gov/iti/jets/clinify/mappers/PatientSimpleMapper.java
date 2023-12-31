package gov.iti.jets.clinify.mappers;

import gov.iti.jets.clinify.models.dtos.simpleDto.PatientSimpleDto;
import gov.iti.jets.clinify.models.entities.Patient;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface PatientSimpleMapper extends BaseMapper<Patient, PatientSimpleDto> {
    Patient toEntity(PatientSimpleDto patientSimpleDto);

    PatientSimpleDto toDto(Patient patient);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Patient partialUpdate(PatientSimpleDto patientSimpleDto, @MappingTarget Patient patient);
}
