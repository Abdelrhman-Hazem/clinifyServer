package gov.iti.jets.clinify.mappers;

import gov.iti.jets.clinify.models.dtos.DoctorSpecializationDto;
import gov.iti.jets.clinify.models.entities.DoctorSpecialization;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface DoctorSpecializationMapper {
    DoctorSpecialization toEntity(DoctorSpecializationDto doctorSpecializationDto);

    @AfterMapping
    default void linkDoctors(@MappingTarget DoctorSpecialization doctorSpecialization) {
        doctorSpecialization.getDoctors().forEach(doctor -> doctor.setDoctorSpecialization(doctorSpecialization));
    }

    DoctorSpecializationDto toDto(DoctorSpecialization doctorSpecialization);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    DoctorSpecialization partialUpdate(DoctorSpecializationDto doctorSpecializationDto, @MappingTarget DoctorSpecialization doctorSpecialization);
}
