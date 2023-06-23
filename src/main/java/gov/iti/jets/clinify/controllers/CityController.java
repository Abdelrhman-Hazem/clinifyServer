package gov.iti.jets.clinify.controllers;

import gov.iti.jets.clinify.models.dtos.CityDto;
import gov.iti.jets.clinify.models.entities.City;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cities")
@CrossOrigin
public class CityController extends BaseController<City, CityDto> {
}
