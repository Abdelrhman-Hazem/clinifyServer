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

import java.util.Optional;

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

    public boolean isEmailExist(String email){
        Optional<Patient> patient = patientRepository.findByEmailIgnoreCase(email);
        if(patient.isPresent()){
            return true;
        }
        return false;
    }
    public Patient isEmailExistObject(String email){
        Optional<Patient> patient = patientRepository.findByEmailIgnoreCase(email);
        if(patient.isPresent()){
            return patient.get();
        }
        return null;
    }

    public boolean isPhoneNumberExist(String phoneNumber){
        Optional<Patient> patient = patientRepository.findByPhoneNumber(phoneNumber);
        if(patient.isPresent()){
            return true;
        }
        return false;
    }
    public Patient isPhoneNumberExistObject(String phoneNumber){
        Optional<Patient> patient = patientRepository.findByPhoneNumber(phoneNumber);
        if(patient.isPresent()){
            return patient.get();
        }
        return null;
    }


    public PatientDto findPatientDataByEmail(String email){
        Optional<Patient> patient = patientRepository.findByEmailIgnoreCase(email);
        return patient.map(x -> mapper().toDto(x)).orElseThrow();
    }

    public PatientDto findPatientDataByPhoneNumber(String phoneNumber){
        Optional<Patient> patient = patientRepository.findByPhoneNumber(phoneNumber);
        return patient.map(x -> mapper().toDto(x)).orElseThrow();
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
