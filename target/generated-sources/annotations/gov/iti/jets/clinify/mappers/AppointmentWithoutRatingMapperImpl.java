package gov.iti.jets.clinify.mappers;

import gov.iti.jets.clinify.models.dtos.AppointmentWithoutRatingDto;
import gov.iti.jets.clinify.models.entities.Appointment;
import gov.iti.jets.clinify.models.entities.Doctor;
import gov.iti.jets.clinify.models.entities.Patient;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-06-18T09:40:26+0200",
    comments = "version: 1.5.4.Final, compiler: Eclipse JDT (IDE) 3.34.0.v20230511-1142, environment: Java 17.0.7 (Eclipse Adoptium)"
)
@Component
public class AppointmentWithoutRatingMapperImpl implements AppointmentWithoutRatingMapper {

    @Autowired
    private DoctorSimpleMapper doctorSimpleMapper;
    @Autowired
    private PatientSimpleMapper patientSimpleMapper;

    @Override
    public Appointment toEntity(AppointmentWithoutRatingDto appointmentWithoutRatingDto) {
        if ( appointmentWithoutRatingDto == null ) {
            return null;
        }

        Appointment appointment = new Appointment();

        appointment.setId( appointmentWithoutRatingDto.getId() );
        appointment.setDoctor( doctorSimpleMapper.toEntity( appointmentWithoutRatingDto.getDoctor() ) );
        appointment.setPatient( patientSimpleMapper.toEntity( appointmentWithoutRatingDto.getPatient() ) );
        appointment.setDate( appointmentWithoutRatingDto.getDate() );
        appointment.setStartTime( appointmentWithoutRatingDto.getStartTime() );
        appointment.setEndTime( appointmentWithoutRatingDto.getEndTime() );
        appointment.setCreditCardLastFourDigits( appointmentWithoutRatingDto.getCreditCardLastFourDigits() );

        return appointment;
    }

    @Override
    public AppointmentWithoutRatingDto toDto(Appointment appointment) {
        if ( appointment == null ) {
            return null;
        }

        AppointmentWithoutRatingDto appointmentWithoutRatingDto = new AppointmentWithoutRatingDto();

        appointmentWithoutRatingDto.setCreditCardLastFourDigits( appointment.getCreditCardLastFourDigits() );
        appointmentWithoutRatingDto.setDate( appointment.getDate() );
        appointmentWithoutRatingDto.setDoctor( doctorSimpleMapper.toDto( appointment.getDoctor() ) );
        appointmentWithoutRatingDto.setEndTime( appointment.getEndTime() );
        appointmentWithoutRatingDto.setId( appointment.getId() );
        appointmentWithoutRatingDto.setPatient( patientSimpleMapper.toDto( appointment.getPatient() ) );
        appointmentWithoutRatingDto.setStartTime( appointment.getStartTime() );

        return appointmentWithoutRatingDto;
    }

    @Override
    public Appointment partialUpdate(AppointmentWithoutRatingDto appointmentWithoutRatingDto, Appointment appointment) {
        if ( appointmentWithoutRatingDto == null ) {
            return appointment;
        }

        if ( appointmentWithoutRatingDto.getId() != null ) {
            appointment.setId( appointmentWithoutRatingDto.getId() );
        }
        if ( appointmentWithoutRatingDto.getDoctor() != null ) {
            if ( appointment.getDoctor() == null ) {
                appointment.setDoctor( new Doctor() );
            }
            doctorSimpleMapper.partialUpdate( appointmentWithoutRatingDto.getDoctor(), appointment.getDoctor() );
        }
        if ( appointmentWithoutRatingDto.getPatient() != null ) {
            if ( appointment.getPatient() == null ) {
                appointment.setPatient( new Patient() );
            }
            patientSimpleMapper.partialUpdate( appointmentWithoutRatingDto.getPatient(), appointment.getPatient() );
        }
        if ( appointmentWithoutRatingDto.getDate() != null ) {
            appointment.setDate( appointmentWithoutRatingDto.getDate() );
        }
        if ( appointmentWithoutRatingDto.getStartTime() != null ) {
            appointment.setStartTime( appointmentWithoutRatingDto.getStartTime() );
        }
        if ( appointmentWithoutRatingDto.getEndTime() != null ) {
            appointment.setEndTime( appointmentWithoutRatingDto.getEndTime() );
        }
        if ( appointmentWithoutRatingDto.getCreditCardLastFourDigits() != null ) {
            appointment.setCreditCardLastFourDigits( appointmentWithoutRatingDto.getCreditCardLastFourDigits() );
        }

        return appointment;
    }
}
