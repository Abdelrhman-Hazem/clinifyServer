package gov.iti.jets.clinify.mappers;

import gov.iti.jets.clinify.models.dtos.AreaDto;
import gov.iti.jets.clinify.models.entities.Area;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface AreaMapper extends BaseMapper<Area, AreaDto> {

    @AfterMapping
    default void linkClinics(@MappingTarget Area area) {
        area.getClinics().forEach(clinic -> clinic.setArea(area));
    }


    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Area partialUpdate(AreaDto areaDto, @MappingTarget Area area);
}
