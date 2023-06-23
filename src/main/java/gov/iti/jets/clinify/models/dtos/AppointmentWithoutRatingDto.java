package gov.iti.jets.clinify.models.dtos;

import lombok.*;

import java.io.Serializable;
import java.sql.Time;
import java.sql.Timestamp;

/**
 * DTO for {@link gov.iti.jets.clinify.models.entities.Appointment}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AppointmentWithoutRatingDto extends BaseDto {
    Integer id;
    DoctorDto doctor;
    PatientDto patient;
    Timestamp date;
    Time startTime;
    Time endTime;
    String creditCardLastFourDigits;
}
