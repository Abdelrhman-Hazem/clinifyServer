package gov.iti.jets.clinify.mappers;

import gov.iti.jets.clinify.models.dtos.DoctorSpecializationSimpleDto;
import gov.iti.jets.clinify.models.entities.DoctorSpecialization;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-06-18T09:40:26+0200",
    comments = "version: 1.5.4.Final, compiler: Eclipse JDT (IDE) 3.34.0.v20230511-1142, environment: Java 17.0.7 (Eclipse Adoptium)"
)
@Component
public class DoctorSpecializationSimpleMapperImpl implements DoctorSpecializationSimpleMapper {

    @Override
    public DoctorSpecialization toEntity(DoctorSpecializationSimpleDto doctorSpecializationSimpleDto) {
        if ( doctorSpecializationSimpleDto == null ) {
            return null;
        }

        DoctorSpecialization doctorSpecialization = new DoctorSpecialization();

        doctorSpecialization.setId( doctorSpecializationSimpleDto.getId() );
        doctorSpecialization.setName( doctorSpecializationSimpleDto.getName() );

        return doctorSpecialization;
    }

    @Override
    public DoctorSpecializationSimpleDto toDto(DoctorSpecialization doctorSpecialization) {
        if ( doctorSpecialization == null ) {
            return null;
        }

        DoctorSpecializationSimpleDto doctorSpecializationSimpleDto = new DoctorSpecializationSimpleDto();

        doctorSpecializationSimpleDto.setId( doctorSpecialization.getId() );
        doctorSpecializationSimpleDto.setName( doctorSpecialization.getName() );

        return doctorSpecializationSimpleDto;
    }

    @Override
    public DoctorSpecialization partialUpdate(DoctorSpecializationSimpleDto doctorSpecializationSimpleDto, DoctorSpecialization doctorSpecialization) {
        if ( doctorSpecializationSimpleDto == null ) {
            return doctorSpecialization;
        }

        if ( doctorSpecializationSimpleDto.getId() != null ) {
            doctorSpecialization.setId( doctorSpecializationSimpleDto.getId() );
        }
        if ( doctorSpecializationSimpleDto.getName() != null ) {
            doctorSpecialization.setName( doctorSpecializationSimpleDto.getName() );
        }

        return doctorSpecialization;
    }
}
