package gov.iti.jets.clinify.services;

import gov.iti.jets.clinify.mappers.PatientMapper;
import gov.iti.jets.clinify.mappers.BaseMapper;
import gov.iti.jets.clinify.models.dtos.PatientDto;
import gov.iti.jets.clinify.models.entities.Patient;
import gov.iti.jets.clinify.repositories.PatientRepository;
import gov.iti.jets.clinify.repositories.BaseRepository;
import gov.iti.jets.clinify.utils.MatchPattern;
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

    public PatientDto findPatientDataByEmail(String email){
        Patient patient = patientRepository.findByEmailIgnoreCase(email).get();
        PatientDto patientDto = mapper().toDto(patient);

        return patientDto;
    }

    public PatientDto findPatientDataByPhoneNumber(String phoneNumber){
        Patient patient = patientRepository.findByPhoneNumber(phoneNumber).get();
        PatientDto patientDto = mapper().toDto(patient);

        return patientDto;
    }

    public PatientDto findPatientDataByPhoneNumberOrEmail(String token){
        PatientDto patientDto = null;
        if (MatchPattern.isEmail(token)){
            patientDto = findPatientDataByEmail(token);
        }else if (MatchPattern.isPhoneNumber(token)){
            patientDto = findPatientDataByPhoneNumber(token);
        }

        return patientDto;
    }
}
