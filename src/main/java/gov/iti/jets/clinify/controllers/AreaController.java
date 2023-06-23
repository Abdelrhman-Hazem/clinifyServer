package gov.iti.jets.clinify.controllers;

import gov.iti.jets.clinify.models.dtos.AreaDto;
import gov.iti.jets.clinify.models.entities.Area;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/areas")
@CrossOrigin
public class AreaController extends BaseController<Area, AreaDto> {
}
