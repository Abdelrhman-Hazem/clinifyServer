package gov.iti.jets.clinify.services;

import gov.iti.jets.clinify.mappers.PatientDocumentMapper;
import gov.iti.jets.clinify.mappers.BaseMapper;
import gov.iti.jets.clinify.models.dtos.PatientDocumentDto;
import gov.iti.jets.clinify.models.entities.PatientDocument;
import gov.iti.jets.clinify.repositories.PatientDocumentRepository;
import gov.iti.jets.clinify.repositories.BaseRepository;
import lombok.AllArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class PatientDocumentService extends BaseServiceImp<PatientDocument, PatientDocumentDto>{

    private final PatientDocumentRepository patientDocumentRepository;

    @Override
    public BaseRepository<PatientDocument> Repository() {
        return patientDocumentRepository;
    }

    @Override
    public BaseMapper<PatientDocument, PatientDocumentDto> mapper(){
        return Mappers.getMapper(PatientDocumentMapper.class);
    }

}
