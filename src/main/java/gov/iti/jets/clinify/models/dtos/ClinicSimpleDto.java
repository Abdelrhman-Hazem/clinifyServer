package gov.iti.jets.clinify.models.dtos;

import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link gov.iti.jets.clinify.models.entities.Clinic}
 */
@Value
public class ClinicSimpleDto implements Serializable {
    Integer id;
    String name;
    String phoneNumber;
    String email;
    String address;
}