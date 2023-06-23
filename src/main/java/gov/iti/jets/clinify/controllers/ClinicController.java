package gov.iti.jets.clinify.controllers;

import gov.iti.jets.clinify.models.dtos.ClinicDto;
import gov.iti.jets.clinify.models.entities.Clinic;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/clinics")
@CrossOrigin
public class ClinicController extends BaseController<Clinic, ClinicDto> {
}
