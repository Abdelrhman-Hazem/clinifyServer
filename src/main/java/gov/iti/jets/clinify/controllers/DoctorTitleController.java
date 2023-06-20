package gov.iti.jets.clinify.controllers;

import gov.iti.jets.clinify.models.dtos.DoctorTitleDto;
import gov.iti.jets.clinify.models.entities.DoctorTitle;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/doctorTitles")
@CrossOrigin
public class DoctorTitleController  extends BaseController<DoctorTitle, DoctorTitleDto>{
}
