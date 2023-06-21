package gov.iti.jets.clinify.models.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.io.Serializable;
import java.util.Set;

/**
 * DTO for {@link gov.iti.jets.clinify.models.entities.Clinic}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClinicDto extends BaseDto {
    Integer id;
    AreaDto area;
    CityDto city;
    String username;
    String password;
    String name;
    String phoneNumber;
    String email;
    String address;
    String status;
    Boolean isDeleted;
//    Set<DoctorDto> doctors;
}
