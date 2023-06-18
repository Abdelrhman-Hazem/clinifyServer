package gov.iti.jets.clinify.mappers;

import gov.iti.jets.clinify.models.dtos.ClinicSimpleDto;
import gov.iti.jets.clinify.models.entities.Clinic;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-06-18T09:40:26+0200",
    comments = "version: 1.5.4.Final, compiler: Eclipse JDT (IDE) 3.34.0.v20230511-1142, environment: Java 17.0.7 (Eclipse Adoptium)"
)
@Component
public class ClinicSimpleMapperImpl implements ClinicSimpleMapper {

    @Override
    public Clinic toEntity(ClinicSimpleDto clinicSimpleDto) {
        if ( clinicSimpleDto == null ) {
            return null;
        }

        Clinic clinic = new Clinic();

        clinic.setId( clinicSimpleDto.getId() );
        clinic.setName( clinicSimpleDto.getName() );
        clinic.setPhoneNumber( clinicSimpleDto.getPhoneNumber() );
        clinic.setEmail( clinicSimpleDto.getEmail() );
        clinic.setAddress( clinicSimpleDto.getAddress() );

        return clinic;
    }

    @Override
    public ClinicSimpleDto toDto(Clinic clinic) {
        if ( clinic == null ) {
            return null;
        }

        ClinicSimpleDto clinicSimpleDto = new ClinicSimpleDto();

        clinicSimpleDto.setAddress( clinic.getAddress() );
        clinicSimpleDto.setEmail( clinic.getEmail() );
        clinicSimpleDto.setId( clinic.getId() );
        clinicSimpleDto.setName( clinic.getName() );
        clinicSimpleDto.setPhoneNumber( clinic.getPhoneNumber() );

        return clinicSimpleDto;
    }

    @Override
    public Clinic partialUpdate(ClinicSimpleDto clinicSimpleDto, Clinic clinic) {
        if ( clinicSimpleDto == null ) {
            return clinic;
        }

        if ( clinicSimpleDto.getId() != null ) {
            clinic.setId( clinicSimpleDto.getId() );
        }
        if ( clinicSimpleDto.getName() != null ) {
            clinic.setName( clinicSimpleDto.getName() );
        }
        if ( clinicSimpleDto.getPhoneNumber() != null ) {
            clinic.setPhoneNumber( clinicSimpleDto.getPhoneNumber() );
        }
        if ( clinicSimpleDto.getEmail() != null ) {
            clinic.setEmail( clinicSimpleDto.getEmail() );
        }
        if ( clinicSimpleDto.getAddress() != null ) {
            clinic.setAddress( clinicSimpleDto.getAddress() );
        }

        return clinic;
    }
}
