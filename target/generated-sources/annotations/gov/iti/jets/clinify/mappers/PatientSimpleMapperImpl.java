package gov.iti.jets.clinify.mappers;

import gov.iti.jets.clinify.models.dtos.PatientSimpleDto;
import gov.iti.jets.clinify.models.entities.Patient;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-06-18T09:40:26+0200",
    comments = "version: 1.5.4.Final, compiler: Eclipse JDT (IDE) 3.34.0.v20230511-1142, environment: Java 17.0.7 (Eclipse Adoptium)"
)
@Component
public class PatientSimpleMapperImpl implements PatientSimpleMapper {

    @Override
    public Patient toEntity(PatientSimpleDto patientSimpleDto) {
        if ( patientSimpleDto == null ) {
            return null;
        }

        Patient patient = new Patient();

        patient.setId( patientSimpleDto.getId() );
        patient.setPhoneNumber( patientSimpleDto.getPhoneNumber() );
        patient.setFullName( patientSimpleDto.getFullName() );
        patient.setEmail( patientSimpleDto.getEmail() );
        patient.setBirthDate( patientSimpleDto.getBirthDate() );
        patient.setGender( patientSimpleDto.getGender() );
        patient.setAddress( patientSimpleDto.getAddress() );

        return patient;
    }

    @Override
    public PatientSimpleDto toDto(Patient patient) {
        if ( patient == null ) {
            return null;
        }

        PatientSimpleDto patientSimpleDto = new PatientSimpleDto();

        patientSimpleDto.setAddress( patient.getAddress() );
        patientSimpleDto.setBirthDate( patient.getBirthDate() );
        patientSimpleDto.setEmail( patient.getEmail() );
        patientSimpleDto.setFullName( patient.getFullName() );
        patientSimpleDto.setGender( patient.getGender() );
        patientSimpleDto.setId( patient.getId() );
        patientSimpleDto.setPhoneNumber( patient.getPhoneNumber() );

        return patientSimpleDto;
    }

    @Override
    public Patient partialUpdate(PatientSimpleDto patientSimpleDto, Patient patient) {
        if ( patientSimpleDto == null ) {
            return patient;
        }

        if ( patientSimpleDto.getId() != null ) {
            patient.setId( patientSimpleDto.getId() );
        }
        if ( patientSimpleDto.getPhoneNumber() != null ) {
            patient.setPhoneNumber( patientSimpleDto.getPhoneNumber() );
        }
        if ( patientSimpleDto.getFullName() != null ) {
            patient.setFullName( patientSimpleDto.getFullName() );
        }
        if ( patientSimpleDto.getEmail() != null ) {
            patient.setEmail( patientSimpleDto.getEmail() );
        }
        if ( patientSimpleDto.getBirthDate() != null ) {
            patient.setBirthDate( patientSimpleDto.getBirthDate() );
        }
        if ( patientSimpleDto.getGender() != null ) {
            patient.setGender( patientSimpleDto.getGender() );
        }
        if ( patientSimpleDto.getAddress() != null ) {
            patient.setAddress( patientSimpleDto.getAddress() );
        }

        return patient;
    }
}
