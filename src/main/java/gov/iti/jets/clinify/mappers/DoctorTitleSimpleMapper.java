package gov.iti.jets.clinify.mappers;

import gov.iti.jets.clinify.models.entities.DoctorTitle;
import gov.iti.jets.clinify.models.dtos.simpleDto.DoctorTitleSimpleDto;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface DoctorTitleSimpleMapper extends BaseMapper<DoctorTitle, DoctorTitleSimpleDto>{
    DoctorTitle toEntity(DoctorTitleSimpleDto doctorTitleSimpleDto);

    DoctorTitleSimpleDto toDto(DoctorTitle doctorTitle);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    DoctorTitle partialUpdate(DoctorTitleSimpleDto doctorTitleSimpleDto, @MappingTarget DoctorTitle doctorTitle);
}
