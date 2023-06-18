package gov.iti.jets.clinify.mappers;

import gov.iti.jets.clinify.models.dtos.AppointmentDto;
import gov.iti.jets.clinify.models.dtos.PatientDocumentDto;
import gov.iti.jets.clinify.models.dtos.PatientDto;
import gov.iti.jets.clinify.models.entities.Appointment;
import gov.iti.jets.clinify.models.entities.Area;
import gov.iti.jets.clinify.models.entities.City;
import gov.iti.jets.clinify.models.entities.Patient;
import gov.iti.jets.clinify.models.entities.PatientDocument;
import java.util.LinkedHashSet;
import java.util.Set;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-06-18T09:40:26+0200",
    comments = "version: 1.5.4.Final, compiler: Eclipse JDT (IDE) 3.34.0.v20230511-1142, environment: Java 17.0.7 (Eclipse Adoptium)"
)
@Component
public class PatientMapperImpl implements PatientMapper {

    @Autowired
    private AreaSimpleMapper areaSimpleMapper;
    @Autowired
    private CitySimpleMapper citySimpleMapper;
    @Autowired
    private PatientDocumentMapper patientDocumentMapper;
    @Autowired
    private AppointmentMapper appointmentMapper;

    @Override
    public Patient toEntity(PatientDto patientDto) {
        if ( patientDto == null ) {
            return null;
        }

        Patient patient = new Patient();

        patient.setId( patientDto.getId() );
        patient.setArea( areaSimpleMapper.toEntity( patientDto.getArea() ) );
        patient.setCity( citySimpleMapper.toEntity( patientDto.getCity() ) );
        patient.setPhoneNumber( patientDto.getPhoneNumber() );
        patient.setPassword( patientDto.getPassword() );
        patient.setFullName( patientDto.getFullName() );
        patient.setEmail( patientDto.getEmail() );
        patient.setBirthDate( patientDto.getBirthDate() );
        patient.setGender( patientDto.getGender() );
        patient.setAddress( patientDto.getAddress() );
        patient.setPreperationTime( patientDto.getPreperationTime() );
        patient.setIsDeleted( patientDto.getIsDeleted() );
        patient.setPatientDocuments( patientDocumentDtoSetToPatientDocumentSet( patientDto.getPatientDocuments() ) );
        patient.setAppointments( appointmentDtoSetToAppointmentSet( patientDto.getAppointments() ) );

        linkPatientDocuments( patient );
        linkAppointments( patient );

        return patient;
    }

    @Override
    public PatientDto toDto(Patient patient) {
        if ( patient == null ) {
            return null;
        }

        PatientDto patientDto = new PatientDto();

        patientDto.setAddress( patient.getAddress() );
        patientDto.setAppointments( appointmentSetToAppointmentDtoSet( patient.getAppointments() ) );
        patientDto.setArea( areaSimpleMapper.toDto( patient.getArea() ) );
        patientDto.setBirthDate( patient.getBirthDate() );
        patientDto.setCity( citySimpleMapper.toDto( patient.getCity() ) );
        patientDto.setEmail( patient.getEmail() );
        patientDto.setFullName( patient.getFullName() );
        patientDto.setGender( patient.getGender() );
        patientDto.setId( patient.getId() );
        patientDto.setIsDeleted( patient.getIsDeleted() );
        patientDto.setPassword( patient.getPassword() );
        patientDto.setPatientDocuments( patientDocumentSetToPatientDocumentDtoSet( patient.getPatientDocuments() ) );
        patientDto.setPhoneNumber( patient.getPhoneNumber() );
        patientDto.setPreperationTime( patient.getPreperationTime() );

        return patientDto;
    }

    @Override
    public Patient partialUpdate(PatientDto patientDto, Patient patient) {
        if ( patientDto == null ) {
            return patient;
        }

        if ( patientDto.getId() != null ) {
            patient.setId( patientDto.getId() );
        }
        if ( patientDto.getArea() != null ) {
            if ( patient.getArea() == null ) {
                patient.setArea( new Area() );
            }
            areaSimpleMapper.partialUpdate( patientDto.getArea(), patient.getArea() );
        }
        if ( patientDto.getCity() != null ) {
            if ( patient.getCity() == null ) {
                patient.setCity( new City() );
            }
            citySimpleMapper.partialUpdate( patientDto.getCity(), patient.getCity() );
        }
        if ( patientDto.getPhoneNumber() != null ) {
            patient.setPhoneNumber( patientDto.getPhoneNumber() );
        }
        if ( patientDto.getPassword() != null ) {
            patient.setPassword( patientDto.getPassword() );
        }
        if ( patientDto.getFullName() != null ) {
            patient.setFullName( patientDto.getFullName() );
        }
        if ( patientDto.getEmail() != null ) {
            patient.setEmail( patientDto.getEmail() );
        }
        if ( patientDto.getBirthDate() != null ) {
            patient.setBirthDate( patientDto.getBirthDate() );
        }
        if ( patientDto.getGender() != null ) {
            patient.setGender( patientDto.getGender() );
        }
        if ( patientDto.getAddress() != null ) {
            patient.setAddress( patientDto.getAddress() );
        }
        if ( patientDto.getPreperationTime() != null ) {
            patient.setPreperationTime( patientDto.getPreperationTime() );
        }
        if ( patientDto.getIsDeleted() != null ) {
            patient.setIsDeleted( patientDto.getIsDeleted() );
        }
        if ( patient.getPatientDocuments() != null ) {
            Set<PatientDocument> set = patientDocumentDtoSetToPatientDocumentSet( patientDto.getPatientDocuments() );
            if ( set != null ) {
                patient.getPatientDocuments().clear();
                patient.getPatientDocuments().addAll( set );
            }
        }
        else {
            Set<PatientDocument> set = patientDocumentDtoSetToPatientDocumentSet( patientDto.getPatientDocuments() );
            if ( set != null ) {
                patient.setPatientDocuments( set );
            }
        }
        if ( patient.getAppointments() != null ) {
            Set<Appointment> set1 = appointmentDtoSetToAppointmentSet( patientDto.getAppointments() );
            if ( set1 != null ) {
                patient.getAppointments().clear();
                patient.getAppointments().addAll( set1 );
            }
        }
        else {
            Set<Appointment> set1 = appointmentDtoSetToAppointmentSet( patientDto.getAppointments() );
            if ( set1 != null ) {
                patient.setAppointments( set1 );
            }
        }

        linkPatientDocuments( patient );
        linkAppointments( patient );

        return patient;
    }

    protected Set<PatientDocument> patientDocumentDtoSetToPatientDocumentSet(Set<PatientDocumentDto> set) {
        if ( set == null ) {
            return null;
        }

        Set<PatientDocument> set1 = new LinkedHashSet<PatientDocument>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( PatientDocumentDto patientDocumentDto : set ) {
            set1.add( patientDocumentMapper.toEntity( patientDocumentDto ) );
        }

        return set1;
    }

    protected Set<Appointment> appointmentDtoSetToAppointmentSet(Set<AppointmentDto> set) {
        if ( set == null ) {
            return null;
        }

        Set<Appointment> set1 = new LinkedHashSet<Appointment>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( AppointmentDto appointmentDto : set ) {
            set1.add( appointmentMapper.toEntity( appointmentDto ) );
        }

        return set1;
    }

    protected Set<AppointmentDto> appointmentSetToAppointmentDtoSet(Set<Appointment> set) {
        if ( set == null ) {
            return null;
        }

        Set<AppointmentDto> set1 = new LinkedHashSet<AppointmentDto>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( Appointment appointment : set ) {
            set1.add( appointmentMapper.toDto( appointment ) );
        }

        return set1;
    }

    protected Set<PatientDocumentDto> patientDocumentSetToPatientDocumentDtoSet(Set<PatientDocument> set) {
        if ( set == null ) {
            return null;
        }

        Set<PatientDocumentDto> set1 = new LinkedHashSet<PatientDocumentDto>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( PatientDocument patientDocument : set ) {
            set1.add( patientDocumentMapper.toDto( patientDocument ) );
        }

        return set1;
    }
}
