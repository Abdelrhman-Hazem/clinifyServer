package gov.iti.jets.clinify.services;

import gov.iti.jets.clinify.mappers.PatientMapper;
import gov.iti.jets.clinify.mappers.BaseMapper;
import gov.iti.jets.clinify.models.dtos.PatientDto;
import gov.iti.jets.clinify.models.entities.Patient;
import gov.iti.jets.clinify.repositories.PatientRepository;
import gov.iti.jets.clinify.repositories.BaseRepository;
import lombok.AllArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class PatientService extends BaseServiceImp<Patient, PatientDto>{

    private final PatientRepository patientRepository;

    @Override
    public BaseRepository<Patient> Repository() {
        return patientRepository;
    }

    @Override
    public BaseMapper<Patient, PatientDto> mapper(){
        return Mappers.getMapper(PatientMapper.class);
    }

}
