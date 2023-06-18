package gov.iti.jets.clinify.models.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link gov.iti.jets.clinify.models.entities.Clinic}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClinicSimpleDto implements Serializable {
    Integer id;
    String name;
    String phoneNumber;
    String email;
    String address;
}