package gov.iti.jets.clinify.models.dtos.simpleDto;

import gov.iti.jets.clinify.models.dtos.BaseDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link gov.iti.jets.clinify.models.entities.Area}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AreaSimpleDto extends BaseDto {
    Integer id;
    String name;
}
