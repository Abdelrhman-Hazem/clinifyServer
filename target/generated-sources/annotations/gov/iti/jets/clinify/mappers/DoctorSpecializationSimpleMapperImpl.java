package gov.iti.jets.clinify.mappers;

import gov.iti.jets.clinify.models.dtos.DoctorSpecializationSimpleDto;
import gov.iti.jets.clinify.models.entities.DoctorSpecialization;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-06-16T20:42:29+0200",
    comments = "version: 1.5.4.Final, compiler: javac, environment: Java 17.0.5 (Oracle Corporation)"
)
@Component
public class DoctorSpecializationSimpleMapperImpl implements DoctorSpecializationSimpleMapper {

    @Override
    public DoctorSpecialization toEntity(DoctorSpecializationSimpleDto doctorSpecializationSimpleDto) {
        if ( doctorSpecializationSimpleDto == null ) {
            return null;
        }

        DoctorSpecialization doctorSpecialization = new DoctorSpecialization();

        return doctorSpecialization;
    }

    @Override
    public DoctorSpecializationSimpleDto toDto(DoctorSpecialization doctorSpecialization) {
        if ( doctorSpecialization == null ) {
            return null;
        }

        DoctorSpecializationSimpleDto doctorSpecializationSimpleDto = new DoctorSpecializationSimpleDto();

        return doctorSpecializationSimpleDto;
    }

    @Override
    public DoctorSpecialization partialUpdate(DoctorSpecializationSimpleDto doctorSpecializationSimpleDto, DoctorSpecialization doctorSpecialization) {
        if ( doctorSpecializationSimpleDto == null ) {
            return doctorSpecialization;
        }

        return doctorSpecialization;
    }
}
