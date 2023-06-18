package gov.iti.jets.clinify.models.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link gov.iti.jets.clinify.models.entities.Doctor}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DoctorSimpleDto implements Serializable {
    Integer id;
    String fullName;
    String phoneNumber;
    Double averageRating;
    Integer ratingCount;
}