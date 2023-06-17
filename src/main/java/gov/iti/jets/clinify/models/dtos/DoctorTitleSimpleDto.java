package gov.iti.jets.clinify.models.dtos;

import gov.iti.jets.clinify.models.entities.DoctorTitle;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link DoctorTitle}
 */
@Value
public class DoctorTitleSimpleDto implements Serializable {
    Integer id;
    String name;
}