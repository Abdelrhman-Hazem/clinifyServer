package gov.iti.jets.clinify.controllers;

import gov.iti.jets.clinify.models.dtos.StatsDto;
import gov.iti.jets.clinify.services.StatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stats")
@CrossOrigin
public class StatsController {
    @Autowired
    private StatsService statsService;
    @GetMapping
    public ResponseEntity<StatsDto> getStats() {
        StatsDto statsDTO = statsService.getStats();
        return ResponseEntity.ok(statsDTO);
    }
}
