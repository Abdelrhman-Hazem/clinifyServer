package gov.iti.jets.clinify.mappers;

import gov.iti.jets.clinify.models.dtos.AreaDto;
import gov.iti.jets.clinify.models.dtos.CityDto;
import gov.iti.jets.clinify.models.entities.Area;
import gov.iti.jets.clinify.models.entities.City;
import java.util.LinkedHashSet;
import java.util.Set;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-06-18T09:40:26+0200",
    comments = "version: 1.5.4.Final, compiler: Eclipse JDT (IDE) 3.34.0.v20230511-1142, environment: Java 17.0.7 (Eclipse Adoptium)"
)
@Component
public class CityMapperImpl implements CityMapper {

    @Autowired
    private AreaMapper areaMapper;

    @Override
    public City toEntity(CityDto cityDto) {
        if ( cityDto == null ) {
            return null;
        }

        City city = new City();

        city.setId( cityDto.getId() );
        city.setName( cityDto.getName() );
        city.setAreas( areaDtoSetToAreaSet( cityDto.getAreas() ) );

        linkAreas( city );

        return city;
    }

    @Override
    public CityDto toDto(City city) {
        if ( city == null ) {
            return null;
        }

        CityDto cityDto = new CityDto();

        cityDto.setAreas( areaSetToAreaDtoSet( city.getAreas() ) );
        cityDto.setId( city.getId() );
        cityDto.setName( city.getName() );

        return cityDto;
    }

    @Override
    public City partialUpdate(CityDto cityDto, City city) {
        if ( cityDto == null ) {
            return city;
        }

        if ( cityDto.getId() != null ) {
            city.setId( cityDto.getId() );
        }
        if ( cityDto.getName() != null ) {
            city.setName( cityDto.getName() );
        }
        if ( city.getAreas() != null ) {
            Set<Area> set = areaDtoSetToAreaSet( cityDto.getAreas() );
            if ( set != null ) {
                city.getAreas().clear();
                city.getAreas().addAll( set );
            }
        }
        else {
            Set<Area> set = areaDtoSetToAreaSet( cityDto.getAreas() );
            if ( set != null ) {
                city.setAreas( set );
            }
        }

        linkAreas( city );

        return city;
    }

    protected Set<Area> areaDtoSetToAreaSet(Set<AreaDto> set) {
        if ( set == null ) {
            return null;
        }

        Set<Area> set1 = new LinkedHashSet<Area>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( AreaDto areaDto : set ) {
            set1.add( areaMapper.toEntity( areaDto ) );
        }

        return set1;
    }

    protected Set<AreaDto> areaSetToAreaDtoSet(Set<Area> set) {
        if ( set == null ) {
            return null;
        }

        Set<AreaDto> set1 = new LinkedHashSet<AreaDto>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( Area area : set ) {
            set1.add( areaMapper.toDto( area ) );
        }

        return set1;
    }
}
