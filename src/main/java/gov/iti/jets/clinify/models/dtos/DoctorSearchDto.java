package gov.iti.jets.clinify.models.dtos;

import gov.iti.jets.clinify.models.entities.Area;
import gov.iti.jets.clinify.models.entities.City;
import gov.iti.jets.clinify.models.entities.DoctorSpecialization;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class DoctorSearchDto {
    private DoctorSpecialization specialization;
    private City city;
    private Area area;
    private String clinicName;
}
