package gov.iti.jets.clinify.models.dtos.simpleDto;

import gov.iti.jets.clinify.models.dtos.BaseDto;
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
public class DoctorSpecializationSimpleDto extends BaseDto {
    Integer id;
    String name;
}
