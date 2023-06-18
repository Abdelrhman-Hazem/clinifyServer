package gov.iti.jets.clinify.mappers;

import gov.iti.jets.clinify.models.dtos.AppointmentWithoutRatingDto;
import gov.iti.jets.clinify.models.dtos.DoctorDto;
import gov.iti.jets.clinify.models.entities.Appointment;
import gov.iti.jets.clinify.models.entities.Clinic;
import gov.iti.jets.clinify.models.entities.Doctor;
import gov.iti.jets.clinify.models.entities.DoctorSpecialization;
import gov.iti.jets.clinify.models.entities.DoctorTitle;
import java.util.LinkedHashSet;
import java.util.Set;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-06-18T09:40:27+0200",
    comments = "version: 1.5.4.Final, compiler: Eclipse JDT (IDE) 3.34.0.v20230511-1142, environment: Java 17.0.7 (Eclipse Adoptium)"
)
@Component
public class DoctorMapperImpl implements DoctorMapper {

    @Autowired
    private DoctorTitleSimpleMapper doctorTitleSimpleMapper;
    @Autowired
    private ClinicSimpleMapper clinicSimpleMapper;
    @Autowired
    private DoctorSpecializationSimpleMapper doctorSpecializationSimpleMapper;
    @Autowired
    private AppointmentWithoutRatingMapper appointmentWithoutRatingMapper;

    @Override
    public Doctor toEntity(DoctorDto doctorDto) {
        if ( doctorDto == null ) {
            return null;
        }

        Doctor doctor = new Doctor();

        doctor.setId( doctorDto.getId() );
        doctor.setDoctorTitle( doctorTitleSimpleMapper.toEntity( doctorDto.getDoctorTitle() ) );
        doctor.setClinic( clinicSimpleMapper.toEntity( doctorDto.getClinic() ) );
        doctor.setDoctorSpecialization( doctorSpecializationSimpleMapper.toEntity( doctorDto.getDoctorSpecialization() ) );
        doctor.setFullName( doctorDto.getFullName() );
        doctor.setPhoneNumber( doctorDto.getPhoneNumber() );
        doctor.setTicketPrice( doctorDto.getTicketPrice() );
        doctor.setAverageRating( doctorDto.getAverageRating() );
        doctor.setRatingCount( doctorDto.getRatingCount() );
        doctor.setStatus( doctorDto.getStatus() );
        doctor.setAppointments( appointmentWithoutRatingDtoSetToAppointmentSet( doctorDto.getAppointments() ) );

        linkAppointments( doctor );

        return doctor;
    }

    @Override
    public DoctorDto toDto(Doctor doctor) {
        if ( doctor == null ) {
            return null;
        }

        DoctorDto doctorDto = new DoctorDto();

        doctorDto.setAppointments( appointmentSetToAppointmentWithoutRatingDtoSet( doctor.getAppointments() ) );
        doctorDto.setAverageRating( doctor.getAverageRating() );
        doctorDto.setClinic( clinicSimpleMapper.toDto( doctor.getClinic() ) );
        doctorDto.setDoctorSpecialization( doctorSpecializationSimpleMapper.toDto( doctor.getDoctorSpecialization() ) );
        doctorDto.setDoctorTitle( doctorTitleSimpleMapper.toDto( doctor.getDoctorTitle() ) );
        doctorDto.setFullName( doctor.getFullName() );
        doctorDto.setId( doctor.getId() );
        doctorDto.setPhoneNumber( doctor.getPhoneNumber() );
        doctorDto.setRatingCount( doctor.getRatingCount() );
        doctorDto.setStatus( doctor.getStatus() );
        doctorDto.setTicketPrice( doctor.getTicketPrice() );

        return doctorDto;
    }

    @Override
    public Doctor partialUpdate(DoctorDto doctorDto, Doctor doctor) {
        if ( doctorDto == null ) {
            return doctor;
        }

        if ( doctorDto.getId() != null ) {
            doctor.setId( doctorDto.getId() );
        }
        if ( doctorDto.getDoctorTitle() != null ) {
            if ( doctor.getDoctorTitle() == null ) {
                doctor.setDoctorTitle( new DoctorTitle() );
            }
            doctorTitleSimpleMapper.partialUpdate( doctorDto.getDoctorTitle(), doctor.getDoctorTitle() );
        }
        if ( doctorDto.getClinic() != null ) {
            if ( doctor.getClinic() == null ) {
                doctor.setClinic( new Clinic() );
            }
            clinicSimpleMapper.partialUpdate( doctorDto.getClinic(), doctor.getClinic() );
        }
        if ( doctorDto.getDoctorSpecialization() != null ) {
            if ( doctor.getDoctorSpecialization() == null ) {
                doctor.setDoctorSpecialization( new DoctorSpecialization() );
            }
            doctorSpecializationSimpleMapper.partialUpdate( doctorDto.getDoctorSpecialization(), doctor.getDoctorSpecialization() );
        }
        if ( doctorDto.getFullName() != null ) {
            doctor.setFullName( doctorDto.getFullName() );
        }
        if ( doctorDto.getPhoneNumber() != null ) {
            doctor.setPhoneNumber( doctorDto.getPhoneNumber() );
        }
        doctor.setTicketPrice( doctorDto.getTicketPrice() );
        if ( doctorDto.getAverageRating() != null ) {
            doctor.setAverageRating( doctorDto.getAverageRating() );
        }
        if ( doctorDto.getRatingCount() != null ) {
            doctor.setRatingCount( doctorDto.getRatingCount() );
        }
        if ( doctorDto.getStatus() != null ) {
            doctor.setStatus( doctorDto.getStatus() );
        }
        if ( doctor.getAppointments() != null ) {
            Set<Appointment> set = appointmentWithoutRatingDtoSetToAppointmentSet( doctorDto.getAppointments() );
            if ( set != null ) {
                doctor.getAppointments().clear();
                doctor.getAppointments().addAll( set );
            }
        }
        else {
            Set<Appointment> set = appointmentWithoutRatingDtoSetToAppointmentSet( doctorDto.getAppointments() );
            if ( set != null ) {
                doctor.setAppointments( set );
            }
        }

        linkAppointments( doctor );

        return doctor;
    }

    protected Set<Appointment> appointmentWithoutRatingDtoSetToAppointmentSet(Set<AppointmentWithoutRatingDto> set) {
        if ( set == null ) {
            return null;
        }

        Set<Appointment> set1 = new LinkedHashSet<Appointment>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( AppointmentWithoutRatingDto appointmentWithoutRatingDto : set ) {
            set1.add( appointmentWithoutRatingMapper.toEntity( appointmentWithoutRatingDto ) );
        }

        return set1;
    }

    protected Set<AppointmentWithoutRatingDto> appointmentSetToAppointmentWithoutRatingDtoSet(Set<Appointment> set) {
        if ( set == null ) {
            return null;
        }

        Set<AppointmentWithoutRatingDto> set1 = new LinkedHashSet<AppointmentWithoutRatingDto>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( Appointment appointment : set ) {
            set1.add( appointmentWithoutRatingMapper.toDto( appointment ) );
        }

        return set1;
    }
}
