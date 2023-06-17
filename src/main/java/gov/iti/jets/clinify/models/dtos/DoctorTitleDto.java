package gov.iti.jets.clinify.models.dtos;

import lombok.Value;

import java.io.Serializable;
import java.util.Set;

/**
 * DTO for {@link gov.iti.jets.clinify.models.entities.DoctorTitle}
 */
@Value
public class DoctorTitleDto implements Serializable {
    Integer id;
    String name;
    Set<DoctorDto> doctors;
}