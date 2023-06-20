package gov.iti.jets.clinify.controllers;

import gov.iti.jets.clinify.exceptions.FieldNotUniqueException;
import gov.iti.jets.clinify.mappers.DoctorMapper;
import gov.iti.jets.clinify.models.dtos.DoctorDto;
import gov.iti.jets.clinify.models.entities.Doctor;
import gov.iti.jets.clinify.services.DoctorService;
import gov.iti.jets.clinify.utils.MessageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/doctors")
public class DoctorController extends BaseController<Doctor, DoctorDto> {

    @Autowired
    private DoctorService doctorService;

    @PutMapping( "/updateDoctor")
    public ResponseEntity<MessageResponse> updateDoctor(@RequestBody DoctorDto dto) {
        DoctorDto doctorDto = this.doctorService.findByPhoneNumber(dto.getPhoneNumber());
        if(doctorDto != null && !doctorDto.getId().equals(dto.getId())){
            throw new FieldNotUniqueException("phoneNumber", "Already Exists");
        }
        doctorService.save(dto);
        return new ResponseEntity<>(new MessageResponse("Doctor Updated Successfully"), HttpStatus.OK);
    }

}
