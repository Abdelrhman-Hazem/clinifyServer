package gov.iti.jets.clinify.models.dtos;

import lombok.Value;

import java.io.Serializable;
import java.sql.Time;
import java.sql.Timestamp;

/**
 * DTO for {@link gov.iti.jets.clinify.models.entities.Appointment}
 */
@Value
public class AppointmentDto implements Serializable {
    Integer id;
    DoctorSimpleDto doctor;
    PatientSimpleDto patient;
    Timestamp date;
    Time startTime;
    Time endTime;
    String creditCardLastFourDigits;
    String status;
    Integer rating;
    String description;
}