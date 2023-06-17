package gov.iti.jets.clinify.models.dtos;

import lombok.Value;

import java.io.Serializable;
import java.util.Set;

/**
 * DTO for {@link gov.iti.jets.clinify.models.entities.Doctor}
 */
@Value
public class DoctorDto implements Serializable {
    Integer id;
    DoctorTitleSimpleDto doctorTitle;
    ClinicSimpleDto clinic;
    DoctorSpecializationSimpleDto doctorSpecialization;
    String fullName;
    String phoneNumber;
    int ticketPrice;
    Double averageRating;
    Integer ratingCount;
    String status;
    Set<AppointmentWithoutRatingDto> appointments;
}