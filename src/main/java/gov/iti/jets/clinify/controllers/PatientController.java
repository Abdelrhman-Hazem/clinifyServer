package gov.iti.jets.clinify.controllers;

import gov.iti.jets.clinify.models.dtos.BaseDto;
import gov.iti.jets.clinify.models.dtos.PatientDto;
import gov.iti.jets.clinify.models.entities.Patient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/patients")
@CrossOrigin
public class PatientController extends BaseController<Patient, PatientDto> {

    @Autowired
    private PatientService patientService;

    @PostMapping( "/addPatient")
    public ResponseEntity<PatientDto> addPatient(@RequestBody PatientDto dto) {
        PatientDto patientDto = this.patientService.findByPhoneNumber(dto.getPhoneNumber());
        PatientDto patientDto2= this.patientService.findByEmail(dto.getEmail());

        if(patientDto != null){
            throw new FieldNotUniqueException("phone", "Already Exists");
        }else if(patientDto2 != null){
            throw new FieldNotUniqueException("email", "Already Exists");
        }
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

        return ResponseEntity.ok().body(patientDto);
    }
}
