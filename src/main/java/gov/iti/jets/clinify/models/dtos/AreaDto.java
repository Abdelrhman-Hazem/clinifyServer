package gov.iti.jets.clinify.models.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.io.Serializable;
import java.util.Set;

/**
 * DTO for {@link gov.iti.jets.clinify.models.entities.Area}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AreaDto implements Serializable {
    Integer id;
    CitySimpleDto city;
    String name;
    Set<ClinicDto> clinics;
}