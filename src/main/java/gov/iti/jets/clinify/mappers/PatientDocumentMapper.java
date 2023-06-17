package gov.iti.jets.clinify.mappers;

import gov.iti.jets.clinify.models.dtos.PatientDocumentDto;
import gov.iti.jets.clinify.models.entities.PatientDocument;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface PatientDocumentMapper {
    PatientDocument toEntity(PatientDocumentDto patientDocumentDto);

    PatientDocumentDto toDto(PatientDocument patientDocument);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    PatientDocument partialUpdate(PatientDocumentDto patientDocumentDto, @MappingTarget PatientDocument patientDocument);
}