package gov.iti.jets.clinify.models.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StatsDto {
    private long totalDoctorCount;
    private long totalPatientCount;
    private long totalSpecialityCount;
    private long totalCityCount;
}
