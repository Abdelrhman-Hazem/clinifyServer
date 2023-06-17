package gov.iti.jets.clinify.models.dtos;

import lombok.Value;

import java.io.Serializable;
import java.util.Set;

/**
 * DTO for {@link gov.iti.jets.clinify.models.entities.Clinic}
 */
@Value
public class ClinicDto implements Serializable {
    Integer id;
    AreaSimpleDto area;
    CitySimpleDto city;
    String username;
    String password;
    String name;
    String phoneNumber;
    String email;
    String address;
    String status;
    Boolean isDeleted;
    Set<DoctorDto> doctors;
}