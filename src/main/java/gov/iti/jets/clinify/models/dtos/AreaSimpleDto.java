package gov.iti.jets.clinify.models.dtos;

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
public class AreaSimpleDto implements Serializable {
    Integer id;
    String name;
}