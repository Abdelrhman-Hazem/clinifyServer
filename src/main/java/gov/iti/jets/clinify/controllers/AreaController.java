package gov.iti.jets.clinify.controllers;

import gov.iti.jets.clinify.models.dtos.AreaDto;
import gov.iti.jets.clinify.models.entities.Area;
import gov.iti.jets.clinify.services.AreaService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/areas")
@CrossOrigin
public class AreaController extends BaseController<Area, AreaDto> {

    @Autowired
    private AreaService areaService;

    @GetMapping("/areasByCityId/{cityId}")
    public ResponseEntity<List<AreaDto>> getAreasByCity(@PathVariable Integer cityId){

        return new ResponseEntity<>(areaService.getAreasByCityId(cityId), HttpStatus.OK);
    }
}
