package gov.iti.jets.clinify.controllers;

import gov.iti.jets.clinify.models.dtos.PatientDto;
import gov.iti.jets.clinify.models.entities.Patient;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/patients")
@CrossOrigin
public class PatientController extends BaseController<Patient, PatientDto> {
}
