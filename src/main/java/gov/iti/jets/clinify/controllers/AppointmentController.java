package gov.iti.jets.clinify.controllers;

import gov.iti.jets.clinify.models.dtos.AppointmentDto;
import gov.iti.jets.clinify.models.entities.Appointment;
import gov.iti.jets.clinify.services.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/appointments")
@CrossOrigin
public class AppointmentController extends BaseController<Appointment, AppointmentDto> {
    @Autowired
    private AppointmentService appointmentService;

    @GetMapping(value = "/byPatientId/{id}")
    public List<AppointmentDto> getAllByPatientId(@PathVariable(value = "id") Integer doctorId){
        return appointmentService.findAllByPatientId(doctorId);
    }

//    @GetMapping(value = "/byDoctorId/{id}")
//    public List<AppointmentDto> getAllByDoctorId(@PathVariable(value = "id") Integer doctorId){
//        return appointmentService.findAllByDoctorId(doctorId);
//    }
//
//    @GetMapping(value = "/byDoctorId/upcoming/{id}")
//    public List<AppointmentDto> getAllUpcomingByDoctorId(@PathVariable(value = "id") Integer doctorId){
//        return appointmentService.findAllUpcomingByDoctorId(doctorId);
//    }


}
