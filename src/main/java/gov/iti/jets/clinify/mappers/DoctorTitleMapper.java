package gov.iti.jets.clinify.mappers;

import gov.iti.jets.clinify.models.dtos.DoctorTitleDto;
import gov.iti.jets.clinify.models.entities.DoctorTitle;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface DoctorTitleMapper {
    DoctorTitle toEntity(DoctorTitleDto doctorTitleDto);

    @AfterMapping
    default void linkDoctors(@MappingTarget DoctorTitle doctorTitle) {
        doctorTitle.getDoctors().forEach(doctor -> doctor.setDoctorTitle(doctorTitle));
    }

    DoctorTitleDto toDto(DoctorTitle doctorTitle);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    DoctorTitle partialUpdate(DoctorTitleDto doctorTitleDto, @MappingTarget DoctorTitle doctorTitle);
}
