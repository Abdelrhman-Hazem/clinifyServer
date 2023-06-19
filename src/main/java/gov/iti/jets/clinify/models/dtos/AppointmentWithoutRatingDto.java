package gov.iti.jets.clinify.models.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.io.Serializable;
import java.sql.Time;
import java.sql.Timestamp;

/**
 * DTO for {@link gov.iti.jets.clinify.models.entities.Appointment}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppointmentWithoutRatingDto implements Serializable {
    Integer id;
    DoctorSimpleDto doctor;
    PatientSimpleDto patient;
    Timestamp date;
    Time startTime;
    Time endTime;
    String creditCardLastFourDigits;
}