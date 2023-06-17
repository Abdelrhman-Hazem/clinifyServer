package gov.iti.jets.clinify.models.dtos;

import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link gov.iti.jets.clinify.models.entities.Area}
 */
@Value
public class AreaSimpleDto implements Serializable {
    Integer id;
    String name;
}