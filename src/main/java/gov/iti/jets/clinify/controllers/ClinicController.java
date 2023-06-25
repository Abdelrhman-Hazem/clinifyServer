package gov.iti.jets.clinify.controllers;

import gov.iti.jets.clinify.exceptions.FieldNotUniqueException;
import gov.iti.jets.clinify.models.dtos.BaseDto;
import gov.iti.jets.clinify.models.dtos.ClinicDto;
import gov.iti.jets.clinify.models.dtos.DoctorDto;
import gov.iti.jets.clinify.models.dtos.PatientDto;
import gov.iti.jets.clinify.models.entities.Clinic;
import gov.iti.jets.clinify.services.ClinicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clinics")
@CrossOrigin
public class ClinicController extends BaseController<Clinic, ClinicDto> {
    @Autowired
    private ClinicService clinicService;

    @Autowired
    private PasswordEncoder passwordEncoder;


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


    @GetMapping("/allPending")
    public ResponseEntity<List<ClinicDto>> getAllPending(){
        List<ClinicDto> pendingClinics = clinicService.findAllPending();
        return ResponseEntity.ok(pendingClinics);

    }

    @PostMapping( "/addClinic")
    public ResponseEntity<ClinicDto> addClinic(@RequestBody ClinicDto dto) {
        boolean clinic = this.clinicService.isPhoneNumberExist(dto.getPhoneNumber());
        boolean clinic2= this.clinicService.isEmailExist(dto.getEmail());

        if(clinic == true){
            throw new FieldNotUniqueException("name", "Already Exists");
        }else if(clinic2 == true){
            throw new FieldNotUniqueException("email", "Already Exists");
        }

        //Hashing password
        String hashedPassword = passwordEncoder.encode(dto.getPassword());
        dto.setPassword(hashedPassword);

        ClinicDto savedDto  = clinicService.save(dto);
        return new ResponseEntity<>(savedDto, HttpStatus.OK);
    }
}
