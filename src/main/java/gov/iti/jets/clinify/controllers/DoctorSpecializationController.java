package gov.iti.jets.clinify.controllers;

import gov.iti.jets.clinify.models.dtos.DoctorSpecializationDto;
import gov.iti.jets.clinify.models.entities.DoctorSpecialization;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/doctorSpecs")
@CrossOrigin
public class DoctorSpecializationController extends BaseController<DoctorSpecialization, DoctorSpecializationDto>{
}
