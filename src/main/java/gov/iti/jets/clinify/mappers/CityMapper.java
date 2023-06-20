package gov.iti.jets.clinify.mappers;

import gov.iti.jets.clinify.models.dtos.CityDto;
import gov.iti.jets.clinify.models.dtos.DoctorDto;
import gov.iti.jets.clinify.models.entities.City;
import gov.iti.jets.clinify.models.entities.Doctor;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface CityMapper extends BaseMapper<City, CityDto> {

    @AfterMapping
    default void linkAreas(@MappingTarget City city) {
        city.getAreas().forEach(area -> area.setCity(city));
    }

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    City partialUpdate(CityDto cityDto, @MappingTarget City city);
}
