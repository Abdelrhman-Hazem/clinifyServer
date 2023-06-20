package gov.iti.jets.clinify.services;

import gov.iti.jets.clinify.mappers.AreaMapper;
import gov.iti.jets.clinify.mappers.BaseMapper;
import gov.iti.jets.clinify.models.dtos.AreaDto;
import gov.iti.jets.clinify.models.entities.Area;
import gov.iti.jets.clinify.repositories.AreaRepository;
import gov.iti.jets.clinify.repositories.BaseRepository;
import lombok.AllArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class AreaService extends BaseServiceImp<Area, AreaDto>{

    private final AreaRepository areaRepository;

    @Override
    public BaseRepository<Area> Repository() {
        return areaRepository;
    }

    @Override
    public BaseMapper<Area, AreaDto> mapper(){
        return Mappers.getMapper(AreaMapper.class);
    }

}
