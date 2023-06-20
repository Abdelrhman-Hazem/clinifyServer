package gov.iti.jets.clinify.controllers;

import gov.iti.jets.clinify.models.dtos.AreaDto;
import gov.iti.jets.clinify.models.entities.Area;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/areas")
public class AreaController extends BaseController<Area, AreaDto> {
}
