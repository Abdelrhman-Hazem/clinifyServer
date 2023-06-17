package gov.iti.jets.clinify.models.dtos;

import lombok.Value;

import java.io.Serializable;
import java.sql.Date;
import java.util.Set;

/**
 * DTO for {@link gov.iti.jets.clinify.models.entities.Patient}
 */
@Value
public class PatientDto implements Serializable {
    Integer id;
    AreaSimpleDto area;
    CitySimpleDto city;
    String phoneNumber;
    String password;
    String fullName;
    String email;
    Date birthDate;
    String gender;
    String address;
    Integer preperationTime;
    Boolean isDeleted;
    Set<PatientDocumentDto> patientDocuments;
    Set<AppointmentDto> appointments;
}