package gov.iti.jets.clinify.mappers;

import gov.iti.jets.clinify.models.dtos.CitySimpleDto;
import gov.iti.jets.clinify.models.entities.City;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-06-16T20:42:29+0200",
    comments = "version: 1.5.4.Final, compiler: javac, environment: Java 17.0.5 (Oracle Corporation)"
)
@Component
public class CitySimpleMapperImpl implements CitySimpleMapper {

    @Override
    public City toEntity(CitySimpleDto citySimpleDto) {
        if ( citySimpleDto == null ) {
            return null;
        }

        City city = new City();

        return city;
    }

    @Override
    public CitySimpleDto toDto(City city) {
        if ( city == null ) {
            return null;
        }

        CitySimpleDto citySimpleDto = new CitySimpleDto();

        return citySimpleDto;
    }

    @Override
    public City partialUpdate(CitySimpleDto citySimpleDto, City city) {
        if ( citySimpleDto == null ) {
            return city;
        }

        return city;
    }
}
