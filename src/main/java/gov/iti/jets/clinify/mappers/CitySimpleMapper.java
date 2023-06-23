package gov.iti.jets.clinify.mappers;

import gov.iti.jets.clinify.models.dtos.CityDto;
import gov.iti.jets.clinify.models.dtos.simpleDto.CitySimpleDto;
import gov.iti.jets.clinify.models.entities.City;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface CitySimpleMapper extends BaseMapper<City, CitySimpleDto>{
    City toEntity(CitySimpleDto citySimpleDto);

    CitySimpleDto toDto(City city);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    City partialUpdate(CitySimpleDto citySimpleDto, @MappingTarget City city);
}
