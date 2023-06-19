package gov.iti.jets.clinify.models.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.io.Serializable;
import java.util.Set;

/**
 * DTO for {@link gov.iti.jets.clinify.models.entities.DoctorTitle}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DoctorTitleDto implements Serializable {
    Integer id;
    String name;
    Set<DoctorDto> doctors;
}