package gov.iti.jets.clinify.controllers;

import gov.iti.jets.clinify.models.dtos.BaseDto;
import gov.iti.jets.clinify.models.dtos.ClinicDto;
import gov.iti.jets.clinify.models.entities.Clinic;
import gov.iti.jets.clinify.services.ClinicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clinics")
@CrossOrigin
public class ClinicController extends BaseController<Clinic, ClinicDto> {
    @Autowired
    private ClinicService clinicService;

    @GetMapping("/data/email")
    public ResponseEntity<BaseDto> getClinicProfileByEmail(@RequestParam(value = "email") String email) {
        ClinicDto clinicDto = clinicService.findClinicDataByEmail(email);

        return ResponseEntity.ok().body(clinicDto);
    }
    @GetMapping("/data/phoneNumber")
    public ResponseEntity<BaseDto> getClinicProfileByPhoneNumber(@RequestParam(value = "phoneNumber") String phoneNumber) {
        ClinicDto clinicDto = clinicService.findClinicDataByPhoneNumber(phoneNumber);

        return ResponseEntity.ok().body(clinicDto);
    }
    @GetMapping("/data")
    public ResponseEntity<BaseDto> getClinicProfileByPhoneNumberOrEmail(@RequestParam(value = "userName") String userName) {
        ClinicDto clinicDto = clinicService.findClinicDataByPhoneNumberOrEmail(userName);

        return ResponseEntity.ok().body(clinicDto);
    }
}
