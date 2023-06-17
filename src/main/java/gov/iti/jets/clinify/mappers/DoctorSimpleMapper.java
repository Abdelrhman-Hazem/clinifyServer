package gov.iti.jets.clinify.mappers;

import gov.iti.jets.clinify.models.dtos.DoctorSimpleDto;
import gov.iti.jets.clinify.models.entities.Doctor;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface DoctorSimpleMapper {
    Doctor toEntity(DoctorSimpleDto doctorSimpleDto);

    DoctorSimpleDto toDto(Doctor doctor);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Doctor partialUpdate(DoctorSimpleDto doctorSimpleDto, @MappingTarget Doctor doctor);
}