package gov.iti.jets.clinify.models.dtos.simpleDto;

import gov.iti.jets.clinify.models.dtos.BaseDto;
import gov.iti.jets.clinify.models.entities.DoctorTitle;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link DoctorTitle}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DoctorTitleSimpleDto extends BaseDto {
    Integer id;
    String name;
}
