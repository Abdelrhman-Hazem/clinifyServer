package gov.iti.jets.clinify.models.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.sql.Time;
import java.sql.Timestamp;

/**
 * DTO for {@link gov.iti.jets.clinify.models.entities.Appointment}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppointmentDto extends BaseDto {
    Integer id;
    DoctorDto doctor;
    PatientDto patient;
    Timestamp date;
    Time startTime;
    Time endTime;
    String creditCardLastFourDigits;
    String status;
    Integer rating;
    String description;
}
