package gov.iti.jets.clinify.mappers;

import gov.iti.jets.clinify.models.dtos.AreaDto;
import gov.iti.jets.clinify.models.entities.Area;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING, uses = {CitySimpleMapper.class, ClinicMapper.class})
public interface AreaMapper {
    Area toEntity(AreaDto areaDto);

    @AfterMapping
    default void linkClinics(@MappingTarget Area area) {
        area.getClinics().forEach(clinic -> clinic.setArea(area));
    }

    AreaDto toDto(Area area);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Area partialUpdate(AreaDto areaDto, @MappingTarget Area area);
}