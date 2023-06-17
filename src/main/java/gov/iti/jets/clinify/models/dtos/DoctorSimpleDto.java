package gov.iti.jets.clinify.models.dtos;

import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link gov.iti.jets.clinify.models.entities.Doctor}
 */
@Value
public class DoctorSimpleDto implements Serializable {
    Integer id;
    String fullName;
    String phoneNumber;
    Double averageRating;
    Integer ratingCount;
}