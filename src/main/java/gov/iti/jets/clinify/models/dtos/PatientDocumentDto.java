package gov.iti.jets.clinify.models.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.io.Serializable;
import java.sql.Date;

/**
 * DTO for {@link gov.iti.jets.clinify.models.entities.PatientDocument}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatientDocumentDto extends BaseDto {
    Integer id;
    Date date;
    String documentUrl;
    String description;
}