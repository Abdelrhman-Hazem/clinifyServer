package gov.iti.jets.clinify.mappers;

import gov.iti.jets.clinify.models.dtos.CityDto;
import gov.iti.jets.clinify.models.entities.City;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING, uses = {AreaMapper.class})
public interface CityMapper {
    City toEntity(CityDto cityDto);

    @AfterMapping
    default void linkAreas(@MappingTarget City city) {
        city.getAreas().forEach(area -> area.setCity(city));
    }

    CityDto toDto(City city);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    City partialUpdate(CityDto cityDto, @MappingTarget City city);
}