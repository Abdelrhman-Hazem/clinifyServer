package gov.iti.jets.clinify.mappers;

import gov.iti.jets.clinify.models.dtos.PatientDocumentDto;
import gov.iti.jets.clinify.models.entities.PatientDocument;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-06-16T20:42:29+0200",
    comments = "version: 1.5.4.Final, compiler: javac, environment: Java 17.0.5 (Oracle Corporation)"
)
@Component
public class PatientDocumentMapperImpl implements PatientDocumentMapper {

    @Override
    public PatientDocument toEntity(PatientDocumentDto patientDocumentDto) {
        if ( patientDocumentDto == null ) {
            return null;
        }

        PatientDocument patientDocument = new PatientDocument();

        return patientDocument;
    }

    @Override
    public PatientDocumentDto toDto(PatientDocument patientDocument) {
        if ( patientDocument == null ) {
            return null;
        }

        PatientDocumentDto patientDocumentDto = new PatientDocumentDto();

        return patientDocumentDto;
    }

    @Override
    public PatientDocument partialUpdate(PatientDocumentDto patientDocumentDto, PatientDocument patientDocument) {
        if ( patientDocumentDto == null ) {
            return patientDocument;
        }

        return patientDocument;
    }
}
