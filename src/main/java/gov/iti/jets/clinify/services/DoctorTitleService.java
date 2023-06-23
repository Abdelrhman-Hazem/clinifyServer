package gov.iti.jets.clinify.services;

import gov.iti.jets.clinify.mappers.BaseMapper;

import gov.iti.jets.clinify.mappers.DoctorTitleMapper;
import gov.iti.jets.clinify.models.dtos.DoctorTitleDto;
import gov.iti.jets.clinify.models.entities.DoctorTitle;
import gov.iti.jets.clinify.repositories.BaseRepository;
import gov.iti.jets.clinify.repositories.DoctorTitleRepository;
import lombok.AllArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class DoctorTitleService extends BaseServiceImp<DoctorTitle, DoctorTitleDto>{

    private final DoctorTitleRepository doctorTitleRepository;

    @Override
    public BaseRepository<DoctorTitle> Repository() {
        return doctorTitleRepository;
    }

    @Override
    public BaseMapper<DoctorTitle, DoctorTitleDto> mapper(){
        return Mappers.getMapper(DoctorTitleMapper.class);
    }


}
