package gov.iti.jets.clinify.controllers;

import gov.iti.jets.clinify.models.dtos.BaseDto;
import gov.iti.jets.clinify.models.dtos.PatientDto;
import gov.iti.jets.clinify.models.entities.Patient;
import gov.iti.jets.clinify.services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/patients")
@CrossOrigin
public class PatientController extends BaseController<Patient, PatientDto> {
    @Autowired
    private PatientService patientService;

    @GetMapping("/data/email")
    public ResponseEntity<BaseDto> getPatientProfileByEmail(@RequestParam(value = "email") String email) {
        PatientDto patientDto = patientService.findPatientDataByEmail(email);

        return ResponseEntity.ok().body(patientDto);
    }
    @GetMapping("/data/phonenumber")
    public ResponseEntity<BaseDto> getPatientProfileByPhoneNumber(@RequestParam(value = "phoneNumber") String phoneNumber) {
        PatientDto patientDto = patientService.findPatientDataByPhoneNumber(phoneNumber);

        return ResponseEntity.ok().body(patientDto);
    }
    @CrossOrigin
    @GetMapping("/data")
    public ResponseEntity<BaseDto> getPatientProfileByPhoneNumberOrEmail(@RequestParam(value = "userName") String userName) {
        PatientDto patientDto = patientService.findPatientDataByPhoneNumberOrEmail(userName);

        return ResponseEntity.ok().body(patientDto);
    }
}
