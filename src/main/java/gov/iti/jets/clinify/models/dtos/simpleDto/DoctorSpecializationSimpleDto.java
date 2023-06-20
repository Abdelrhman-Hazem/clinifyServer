package gov.iti.jets.clinify.models.dtos.simpleDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link gov.iti.jets.clinify.models.entities.DoctorSpecialization}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DoctorSpecializationSimpleDto implements Serializable {
    Integer id;
    String name;
}
