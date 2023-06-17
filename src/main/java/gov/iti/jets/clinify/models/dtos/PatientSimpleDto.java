package gov.iti.jets.clinify.models.dtos;

import lombok.Value;

import java.io.Serializable;
import java.sql.Date;

/**
 * DTO for {@link gov.iti.jets.clinify.models.entities.Patient}
 */
@Value
public class PatientSimpleDto implements Serializable {
    Integer id;
    String phoneNumber;
    String fullName;
    String email;
    Date birthDate;
    String gender;
    String address;
}