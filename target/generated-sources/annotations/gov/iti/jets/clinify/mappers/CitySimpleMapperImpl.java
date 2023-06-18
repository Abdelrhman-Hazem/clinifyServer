package gov.iti.jets.clinify.mappers;

import gov.iti.jets.clinify.models.dtos.CitySimpleDto;
import gov.iti.jets.clinify.models.entities.City;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-06-18T09:40:26+0200",
    comments = "version: 1.5.4.Final, compiler: Eclipse JDT (IDE) 3.34.0.v20230511-1142, environment: Java 17.0.7 (Eclipse Adoptium)"
)
@Component
public class CitySimpleMapperImpl implements CitySimpleMapper {

    @Override
    public City toEntity(CitySimpleDto citySimpleDto) {
        if ( citySimpleDto == null ) {
            return null;
        }

        City city = new City();

        city.setId( citySimpleDto.getId() );
        city.setName( citySimpleDto.getName() );

        return city;
    }

    @Override
    public CitySimpleDto toDto(City city) {
        if ( city == null ) {
            return null;
        }

        CitySimpleDto citySimpleDto = new CitySimpleDto();

        citySimpleDto.setId( city.getId() );
        citySimpleDto.setName( city.getName() );

        return citySimpleDto;
    }

    @Override
    public City partialUpdate(CitySimpleDto citySimpleDto, City city) {
        if ( citySimpleDto == null ) {
            return city;
        }

        if ( citySimpleDto.getId() != null ) {
            city.setId( citySimpleDto.getId() );
        }
        if ( citySimpleDto.getName() != null ) {
            city.setName( citySimpleDto.getName() );
        }

        return city;
    }
}
