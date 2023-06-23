package gov.iti.jets.clinify.mappers;

import gov.iti.jets.clinify.models.dtos.ClinicDto;
import gov.iti.jets.clinify.models.entities.Clinic;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface ClinicMapper extends BaseMapper<Clinic, ClinicDto>{
    Clinic toEntity(ClinicDto clinicDto);

    @AfterMapping
    default void linkDoctors(@MappingTarget Clinic clinic) {
        clinic.getDoctors().forEach(doctor -> doctor.setClinic(clinic));
    }

    ClinicDto toDto(Clinic clinic);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Clinic partialUpdate(ClinicDto clinicDto, @MappingTarget Clinic clinic);
}
