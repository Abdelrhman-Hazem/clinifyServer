package gov.iti.jets.clinify.mappers;

import gov.iti.jets.clinify.models.dtos.PatientDocumentDto;
import gov.iti.jets.clinify.models.entities.PatientDocument;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-06-18T09:40:26+0200",
    comments = "version: 1.5.4.Final, compiler: Eclipse JDT (IDE) 3.34.0.v20230511-1142, environment: Java 17.0.7 (Eclipse Adoptium)"
)
@Component
public class PatientDocumentMapperImpl implements PatientDocumentMapper {

    @Override
    public PatientDocument toEntity(PatientDocumentDto patientDocumentDto) {
        if ( patientDocumentDto == null ) {
            return null;
        }

        PatientDocument patientDocument = new PatientDocument();

        patientDocument.setId( patientDocumentDto.getId() );
        patientDocument.setDate( patientDocumentDto.getDate() );
        patientDocument.setDocumentUrl( patientDocumentDto.getDocumentUrl() );
        patientDocument.setDescription( patientDocumentDto.getDescription() );

        return patientDocument;
    }

    @Override
    public PatientDocumentDto toDto(PatientDocument patientDocument) {
        if ( patientDocument == null ) {
            return null;
        }

        PatientDocumentDto patientDocumentDto = new PatientDocumentDto();

        patientDocumentDto.setDate( patientDocument.getDate() );
        patientDocumentDto.setDescription( patientDocument.getDescription() );
        patientDocumentDto.setDocumentUrl( patientDocument.getDocumentUrl() );
        patientDocumentDto.setId( patientDocument.getId() );

        return patientDocumentDto;
    }

    @Override
    public PatientDocument partialUpdate(PatientDocumentDto patientDocumentDto, PatientDocument patientDocument) {
        if ( patientDocumentDto == null ) {
            return patientDocument;
        }

        if ( patientDocumentDto.getId() != null ) {
            patientDocument.setId( patientDocumentDto.getId() );
        }
        if ( patientDocumentDto.getDate() != null ) {
            patientDocument.setDate( patientDocumentDto.getDate() );
        }
        if ( patientDocumentDto.getDocumentUrl() != null ) {
            patientDocument.setDocumentUrl( patientDocumentDto.getDocumentUrl() );
        }
        if ( patientDocumentDto.getDescription() != null ) {
            patientDocument.setDescription( patientDocumentDto.getDescription() );
        }

        return patientDocument;
    }
}
