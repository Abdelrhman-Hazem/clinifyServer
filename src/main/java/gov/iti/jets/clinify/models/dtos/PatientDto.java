package gov.iti.jets.clinify.models.dtos;

import lombok.*;

import java.io.Serializable;
import java.sql.Date;
import java.util.Set;

/**
 * DTO for {@link gov.iti.jets.clinify.models.entities.Patient}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PatientDto extends BaseDto {

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
