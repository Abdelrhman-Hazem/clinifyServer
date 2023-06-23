package gov.iti.jets.clinify.services;

import gov.iti.jets.clinify.mappers.BaseMapper;
import gov.iti.jets.clinify.mappers.DoctorSpecializationMapper;
import gov.iti.jets.clinify.mappers.DoctorSpecializationSimpleMapper;
import gov.iti.jets.clinify.mappers.DoctorTitleMapper;
import gov.iti.jets.clinify.models.dtos.DoctorSpecializationDto;
import gov.iti.jets.clinify.models.dtos.DoctorTitleDto;
import gov.iti.jets.clinify.models.entities.DoctorSpecialization;
import gov.iti.jets.clinify.models.entities.DoctorTitle;
import gov.iti.jets.clinify.repositories.BaseRepository;
import gov.iti.jets.clinify.repositories.DoctorSpecializationRepository;
import gov.iti.jets.clinify.repositories.DoctorTitleRepository;
import lombok.AllArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class DoctorSpecializationService extends BaseServiceImp<DoctorSpecialization, DoctorSpecializationDto>{

    private final DoctorSpecializationRepository doctorSpecializationRepository;

    @Override
    public BaseRepository<DoctorSpecialization> Repository() {
        return doctorSpecializationRepository;
    }

    @Override
    public BaseMapper<DoctorSpecialization, DoctorSpecializationDto> mapper(){
        return Mappers.getMapper(DoctorSpecializationMapper.class);
    }


}
