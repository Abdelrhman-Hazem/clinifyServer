package gov.iti.jets.clinify.services;

import gov.iti.jets.clinify.mappers.ClinicMapper;
import gov.iti.jets.clinify.mappers.BaseMapper;
import gov.iti.jets.clinify.models.dtos.ClinicDto;
import gov.iti.jets.clinify.models.dtos.DoctorDto;
import gov.iti.jets.clinify.models.dtos.PatientDto;
import gov.iti.jets.clinify.models.entities.Clinic;
import gov.iti.jets.clinify.models.entities.Doctor;
import gov.iti.jets.clinify.models.entities.Patient;
import gov.iti.jets.clinify.repositories.ClinicRepository;
import gov.iti.jets.clinify.repositories.BaseRepository;
import gov.iti.jets.clinify.utils.MatchPattern;
import lombok.AllArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class ClinicService extends BaseServiceImp<Clinic, ClinicDto>{

    private final ClinicRepository clinicRepository;

    @Override
    public BaseRepository<Clinic> Repository() {
        return clinicRepository;
    }

    @Override
    public BaseMapper<Clinic, ClinicDto> mapper(){
        return Mappers.getMapper(ClinicMapper.class);
    }

    public ClinicDto findClinicDataByEmail(String email){
        Optional<Clinic> clinic = clinicRepository.findByEmailIgnoreCase(email);
        ClinicDto clinicDto = clinic.map(x -> mapper().toDto(x)).orElseThrow();

        return clinicDto;
    }

    public ClinicDto findClinicDataByPhoneNumber(String phoneNumber){
        Optional<Clinic> clinic = clinicRepository.findByPhoneNumber(phoneNumber);
        ClinicDto clinicDto = clinic.map(x -> mapper().toDto(x)).orElseThrow();

        return clinicDto;
    }

    public ClinicDto findClinicDataByPhoneNumberOrEmail(String token){
        ClinicDto clinicDto = null;
        if (MatchPattern.isEmail(token)){
            clinicDto = findClinicDataByEmail(token);
        }else if (MatchPattern.isPhoneNumber(token)){
            clinicDto = findClinicDataByPhoneNumber(token);
        }

        return clinicDto;
    }

    public List<ClinicDto> findAllPending(){
        return mapper().toDtos(clinicRepository.findAllByStatusIgnoreCase("pending"));
    }

    public boolean isEmailExist(String email){
        Optional<Clinic> clinic = clinicRepository.findByEmailIgnoreCase(email);
        if(clinic.isPresent()){
            return true;
        }
        return false;
    }

    public boolean isPhoneNumberExist(String phoneNumber){
        Optional<Clinic> clinic = clinicRepository.findByPhoneNumber(phoneNumber);
        if(clinic.isPresent()){
            return true;
        }
        return false;
    }


}
