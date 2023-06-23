package gov.iti.jets.clinify.controllers;

import gov.iti.jets.clinify.models.dtos.AppointmentDto;
import gov.iti.jets.clinify.models.dtos.AppointmentWithoutRatingDto;
import gov.iti.jets.clinify.models.entities.Appointment;
import gov.iti.jets.clinify.services.AppointmentService;
import gov.iti.jets.clinify.services.AppointmentWithoutRatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/appointmentsForClinics")
@CrossOrigin
public class AppointmentWithoutRatingController extends BaseController<Appointment, AppointmentDto> {
    @Autowired
    private AppointmentWithoutRatingService appointmentWithoutRatingService;

    @GetMapping(value = "/byDoctorId/{id}")
    public List<AppointmentWithoutRatingDto> getAllByDoctorId(@PathVariable(value = "id") Integer doctorId){
        return appointmentWithoutRatingService.findAllByDoctorId(doctorId);
    }

    @GetMapping(value = "/byDoctorId/upcoming/{id}")
    public List<AppointmentWithoutRatingDto> getAllUpcomingByDoctorId(@PathVariable(value = "id") Integer doctorId){
        return appointmentWithoutRatingService.findAllUpcomingByDoctorId(doctorId);
    }
}
