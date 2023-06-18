package gov.iti.jets.clinify.mappers;

import gov.iti.jets.clinify.models.dtos.DoctorSimpleDto;
import gov.iti.jets.clinify.models.entities.Doctor;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-06-18T09:40:26+0200",
    comments = "version: 1.5.4.Final, compiler: Eclipse JDT (IDE) 3.34.0.v20230511-1142, environment: Java 17.0.7 (Eclipse Adoptium)"
)
@Component
public class DoctorSimpleMapperImpl implements DoctorSimpleMapper {

    @Override
    public Doctor toEntity(DoctorSimpleDto doctorSimpleDto) {
        if ( doctorSimpleDto == null ) {
            return null;
        }

        Doctor doctor = new Doctor();

        doctor.setId( doctorSimpleDto.getId() );
        doctor.setFullName( doctorSimpleDto.getFullName() );
        doctor.setPhoneNumber( doctorSimpleDto.getPhoneNumber() );
        doctor.setAverageRating( doctorSimpleDto.getAverageRating() );
        doctor.setRatingCount( doctorSimpleDto.getRatingCount() );

        return doctor;
    }

    @Override
    public DoctorSimpleDto toDto(Doctor doctor) {
        if ( doctor == null ) {
            return null;
        }

        DoctorSimpleDto doctorSimpleDto = new DoctorSimpleDto();

        doctorSimpleDto.setAverageRating( doctor.getAverageRating() );
        doctorSimpleDto.setFullName( doctor.getFullName() );
        doctorSimpleDto.setId( doctor.getId() );
        doctorSimpleDto.setPhoneNumber( doctor.getPhoneNumber() );
        doctorSimpleDto.setRatingCount( doctor.getRatingCount() );

        return doctorSimpleDto;
    }

    @Override
    public Doctor partialUpdate(DoctorSimpleDto doctorSimpleDto, Doctor doctor) {
        if ( doctorSimpleDto == null ) {
            return doctor;
        }

        if ( doctorSimpleDto.getId() != null ) {
            doctor.setId( doctorSimpleDto.getId() );
        }
        if ( doctorSimpleDto.getFullName() != null ) {
            doctor.setFullName( doctorSimpleDto.getFullName() );
        }
        if ( doctorSimpleDto.getPhoneNumber() != null ) {
            doctor.setPhoneNumber( doctorSimpleDto.getPhoneNumber() );
        }
        if ( doctorSimpleDto.getAverageRating() != null ) {
            doctor.setAverageRating( doctorSimpleDto.getAverageRating() );
        }
        if ( doctorSimpleDto.getRatingCount() != null ) {
            doctor.setRatingCount( doctorSimpleDto.getRatingCount() );
        }

        return doctor;
    }
}
