package gov.iti.jets.clinify.mappers;

import gov.iti.jets.clinify.models.dtos.AppointmentDto;
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
public class AppointmentMapperImpl implements AppointmentMapper {

    @Autowired
    private DoctorSimpleMapper doctorSimpleMapper;
    @Autowired
    private PatientSimpleMapper patientSimpleMapper;

    @Override
    public Appointment toEntity(AppointmentDto appointmentDto) {
        if ( appointmentDto == null ) {
            return null;
        }

        Appointment appointment = new Appointment();

        appointment.setId( appointmentDto.getId() );
        appointment.setDoctor( doctorSimpleMapper.toEntity( appointmentDto.getDoctor() ) );
        appointment.setPatient( patientSimpleMapper.toEntity( appointmentDto.getPatient() ) );
        appointment.setDate( appointmentDto.getDate() );
        appointment.setStartTime( appointmentDto.getStartTime() );
        appointment.setEndTime( appointmentDto.getEndTime() );
        appointment.setCreditCardLastFourDigits( appointmentDto.getCreditCardLastFourDigits() );
        appointment.setStatus( appointmentDto.getStatus() );
        appointment.setRating( appointmentDto.getRating() );
        appointment.setDescription( appointmentDto.getDescription() );

        return appointment;
    }

    @Override
    public AppointmentDto toDto(Appointment appointment) {
        if ( appointment == null ) {
            return null;
        }

        AppointmentDto appointmentDto = new AppointmentDto();

        appointmentDto.setCreditCardLastFourDigits( appointment.getCreditCardLastFourDigits() );
        appointmentDto.setDate( appointment.getDate() );
        appointmentDto.setDescription( appointment.getDescription() );
        appointmentDto.setDoctor( doctorSimpleMapper.toDto( appointment.getDoctor() ) );
        appointmentDto.setEndTime( appointment.getEndTime() );
        appointmentDto.setId( appointment.getId() );
        appointmentDto.setPatient( patientSimpleMapper.toDto( appointment.getPatient() ) );
        appointmentDto.setRating( appointment.getRating() );
        appointmentDto.setStartTime( appointment.getStartTime() );
        appointmentDto.setStatus( appointment.getStatus() );

        return appointmentDto;
    }

    @Override
    public Appointment partialUpdate(AppointmentDto appointmentDto, Appointment appointment) {
        if ( appointmentDto == null ) {
            return appointment;
        }

        if ( appointmentDto.getId() != null ) {
            appointment.setId( appointmentDto.getId() );
        }
        if ( appointmentDto.getDoctor() != null ) {
            if ( appointment.getDoctor() == null ) {
                appointment.setDoctor( new Doctor() );
            }
            doctorSimpleMapper.partialUpdate( appointmentDto.getDoctor(), appointment.getDoctor() );
        }
        if ( appointmentDto.getPatient() != null ) {
            if ( appointment.getPatient() == null ) {
                appointment.setPatient( new Patient() );
            }
            patientSimpleMapper.partialUpdate( appointmentDto.getPatient(), appointment.getPatient() );
        }
        if ( appointmentDto.getDate() != null ) {
            appointment.setDate( appointmentDto.getDate() );
        }
        if ( appointmentDto.getStartTime() != null ) {
            appointment.setStartTime( appointmentDto.getStartTime() );
        }
        if ( appointmentDto.getEndTime() != null ) {
            appointment.setEndTime( appointmentDto.getEndTime() );
        }
        if ( appointmentDto.getCreditCardLastFourDigits() != null ) {
            appointment.setCreditCardLastFourDigits( appointmentDto.getCreditCardLastFourDigits() );
        }
        if ( appointmentDto.getStatus() != null ) {
            appointment.setStatus( appointmentDto.getStatus() );
        }
        if ( appointmentDto.getRating() != null ) {
            appointment.setRating( appointmentDto.getRating() );
        }
        if ( appointmentDto.getDescription() != null ) {
            appointment.setDescription( appointmentDto.getDescription() );
        }

        return appointment;
    }
}
