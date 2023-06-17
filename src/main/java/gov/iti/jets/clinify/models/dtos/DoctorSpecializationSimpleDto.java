package gov.iti.jets.clinify.models.dtos;

import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link gov.iti.jets.clinify.models.entities.DoctorSpecialization}
 */
@Value
public class DoctorSpecializationSimpleDto implements Serializable {
    Integer id;
    String name;
}