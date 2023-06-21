package gov.iti.jets.clinify.controllers;

import gov.iti.jets.clinify.models.dtos.PatientDocumentDto;
import gov.iti.jets.clinify.models.entities.PatientDocument;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/patientDocuments")
@CrossOrigin
public class PatientDocumentController extends BaseController<PatientDocument, PatientDocumentDto> {
}
