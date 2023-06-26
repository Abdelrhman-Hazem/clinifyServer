package gov.iti.jets.clinify.controllers;

import gov.iti.jets.clinify.exceptions.FieldNotUniqueException;
import gov.iti.jets.clinify.models.dtos.BaseDto;
import gov.iti.jets.clinify.models.dtos.PatientDto;
import gov.iti.jets.clinify.models.entities.Patient;
import gov.iti.jets.clinify.services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/patients")
@CrossOrigin
public class PatientController extends BaseController<Patient, PatientDto> {

    @Autowired
    private PatientService patientService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping( "/addPatient")
    public ResponseEntity<PatientDto> addPatient(@RequestBody PatientDto dto) {
        boolean patientDto = this.patientService.isPhoneNumberExist(dto.getPhoneNumber());
        boolean patientDto2= this.patientService.isEmailExist(dto.getEmail());

        if(patientDto == true){
            throw new FieldNotUniqueException("phone", "Already Exists");
        }else if(patientDto2 == true){
            throw new FieldNotUniqueException("email", "Already Exists");
        }

        //Hashing password
        String hashedPassword = passwordEncoder.encode(dto.getPassword());
        dto.setPassword(hashedPassword);

        PatientDto savedDto  = patientService.save(dto);
        return new ResponseEntity<>(savedDto, HttpStatus.OK);
    }

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
        System.out.println(patientDto);
        return ResponseEntity.ok().body(patientDto);
    }

    @PutMapping( "/changePassword")
    public ResponseEntity<PatientDto> changePassword(@RequestBody PatientDto dto) {

        //Hashing password
        String hashedPassword = passwordEncoder.encode(dto.getPassword());
        dto.setPassword(hashedPassword);

        PatientDto savedDto  = patientService.save(dto);
        return new ResponseEntity<>(savedDto, HttpStatus.OK);
    }
}
