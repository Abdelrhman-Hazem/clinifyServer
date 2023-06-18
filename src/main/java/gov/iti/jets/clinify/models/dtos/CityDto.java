package gov.iti.jets.clinify.models.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.io.Serializable;
import java.util.Set;

/**
 * DTO for {@link gov.iti.jets.clinify.models.entities.City}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CityDto implements Serializable {
    Integer id;
    String name;
    Set<AreaDto> areas;
}