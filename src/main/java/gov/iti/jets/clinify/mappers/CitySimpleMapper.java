package gov.iti.jets.clinify.mappers;

import gov.iti.jets.clinify.models.dtos.CitySimpleDto;
import gov.iti.jets.clinify.models.entities.City;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface CitySimpleMapper {
    City toEntity(CitySimpleDto citySimpleDto);

    CitySimpleDto toDto(City city);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    City partialUpdate(CitySimpleDto citySimpleDto, @MappingTarget City city);
}