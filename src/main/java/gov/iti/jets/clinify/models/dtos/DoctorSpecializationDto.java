package gov.iti.jets.clinify.models.dtos;

import lombok.Value;

import java.io.Serializable;
import java.util.Set;

/**
 * DTO for {@link gov.iti.jets.clinify.models.entities.DoctorSpecialization}
 */
@Value
public class DoctorSpecializationDto implements Serializable {
    Integer id;
    String name;
    Set<DoctorDto> doctors;
}