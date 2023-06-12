package gov.iti.jets.clinify.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sample")
public class AASampleController {

    @GetMapping
    public String sayHello(){
        return "Hello from clinify";
    }
}
