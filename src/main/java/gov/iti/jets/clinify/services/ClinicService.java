package gov.iti.jets.clinify.services;

import gov.iti.jets.clinify.mappers.ClinicMapper;
import gov.iti.jets.clinify.mappers.BaseMapper;
import gov.iti.jets.clinify.models.dtos.ClinicDto;
import gov.iti.jets.clinify.models.entities.Clinic;
import gov.iti.jets.clinify.repositories.ClinicRepository;
import gov.iti.jets.clinify.repositories.BaseRepository;
import lombok.AllArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

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

}
