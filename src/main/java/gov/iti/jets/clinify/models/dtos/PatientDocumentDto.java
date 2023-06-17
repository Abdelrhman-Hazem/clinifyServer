package gov.iti.jets.clinify.models.dtos;

import lombok.Value;

import java.io.Serializable;
import java.sql.Date;

/**
 * DTO for {@link gov.iti.jets.clinify.models.entities.PatientDocument}
 */
@Value
public class PatientDocumentDto implements Serializable {
    Integer id;
    Date date;
    String documentUrl;
    String description;
}