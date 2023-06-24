package gov.iti.jets.clinify.controllers;

import gov.iti.jets.clinify.exceptions.FieldNotUniqueException;
import gov.iti.jets.clinify.models.dtos.DoctorDto;
import gov.iti.jets.clinify.models.dtos.PatientDto;
import gov.iti.jets.clinify.models.entities.Patient;
import gov.iti.jets.clinify.services.DoctorService;
import gov.iti.jets.clinify.services.PatientService;
import gov.iti.jets.clinify.utils.MessageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
}
