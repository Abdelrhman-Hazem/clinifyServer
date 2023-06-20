package gov.iti.jets.clinify.mappers;

import gov.iti.jets.clinify.models.dtos.simpleDto.AreaSimpleDto;
import gov.iti.jets.clinify.models.entities.Area;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface AreaSimpleMapper {
    Area toEntity(AreaSimpleDto areaSimpleDto);

    AreaSimpleDto toDto(Area area);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Area partialUpdate(AreaSimpleDto areaSimpleDto, @MappingTarget Area area);
}
