package gov.iti.jets.clinify.models.dtos.simpleDto;

import gov.iti.jets.clinify.models.dtos.BaseDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.io.Serializable;
import java.sql.Date;

/**
 * DTO for {@link gov.iti.jets.clinify.models.entities.Patient}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatientSimpleDto extends BaseDto {
    Integer id;
    String phoneNumber;
    String fullName;
    String email;
    Date birthDate;
    String gender;
    String address;
}
