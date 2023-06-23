package gov.iti.jets.clinify.services;

import gov.iti.jets.clinify.mappers.CityMapper;
import gov.iti.jets.clinify.mappers.BaseMapper;
import gov.iti.jets.clinify.models.dtos.CityDto;
import gov.iti.jets.clinify.models.entities.City;
import gov.iti.jets.clinify.repositories.CityRepository;
import gov.iti.jets.clinify.repositories.BaseRepository;
import lombok.AllArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class CityService extends BaseServiceImp<City, CityDto>{

    private final CityRepository areaRepository;

    @Override
    public BaseRepository<City> Repository() {
        return areaRepository;
    }

    @Override
    public BaseMapper<City, CityDto> mapper(){
        return Mappers.getMapper(CityMapper.class);
    }

}
