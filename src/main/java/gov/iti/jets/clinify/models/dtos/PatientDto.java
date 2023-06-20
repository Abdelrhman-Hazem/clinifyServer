package gov.iti.jets.clinify.models.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.io.Serializable;
import java.sql.Date;
import java.util.Set;

/**
 * DTO for {@link gov.iti.jets.clinify.models.entities.Patient}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatientDto implements Serializable {

    Integer id;
    AreaDto area;
    CityDto city;
    String phoneNumber;
    String password;
    String fullName;
    String email;
    Date birthDate;
    String gender;
    String address;
    Integer preperationTime;
    Boolean isDeleted;
//    Set<PatientDocumentDto> patientDocuments;
//    Set<AppointmentDto> appointments;

}
