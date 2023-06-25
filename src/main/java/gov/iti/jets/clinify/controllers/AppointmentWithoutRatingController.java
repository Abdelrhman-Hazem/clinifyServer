package gov.iti.jets.clinify.controllers;

import gov.iti.jets.clinify.models.dtos.AppointmentDto;
import gov.iti.jets.clinify.models.dtos.AppointmentWithoutRatingDto;
import gov.iti.jets.clinify.models.entities.Appointment;
import gov.iti.jets.clinify.services.AppointmentWithoutRatingService;
import gov.iti.jets.clinify.utils.MessageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/appointmentsForClinics")
@CrossOrigin
public class AppointmentWithoutRatingController extends BaseController<Appointment, AppointmentWithoutRatingDto> {
    @Autowired
    private AppointmentWithoutRatingService appointmentWithoutRatingService;

    @GetMapping(value = "/byDoctorId/full/{id}")
    public List<AppointmentWithoutRatingDto> getAllFullByDoctorId(@PathVariable(value = "id") Integer doctorId){
        return appointmentWithoutRatingService.findAllFullByDoctorId(doctorId);
    }

    @GetMapping(value = "/byDoctorId/full/upcoming/{id}")
    public List<AppointmentWithoutRatingDto> getAllFullUpcomingByDoctorId(@PathVariable(value = "id") Integer doctorId){
        return appointmentWithoutRatingService.findAllFullUpcomingByDoctorId(doctorId);
    }

    @GetMapping(value = "/byDoctorId/divided/{id}")
    public List<AppointmentWithoutRatingDto> getAllDividedByDoctorId(@PathVariable(value = "id") Integer doctorId){
        return appointmentWithoutRatingService.findAllDividedByDoctorId(doctorId);
    }

    @GetMapping(value = "/byDoctorId/divided/upcoming/{id}")
    public List<AppointmentWithoutRatingDto> getAllDividedUpcomingByDoctorId(@PathVariable(value = "id") Integer doctorId){
        return appointmentWithoutRatingService.findAllDividedUpcomingByDoctorId(doctorId);
    }

    @PutMapping(value = "book/{appointmentId}/{patientId}")
    public MessageResponse bookAppointment(@PathVariable(value = "appointmentId") Integer appointmentId, @PathVariable(value = "patientId") Integer patientId){
        appointmentWithoutRatingService.bookAppointment(appointmentId,patientId);
        return new MessageResponse("Item has been saved successfully");
    }

    @PutMapping(value = "rate/{appointmentId}/rating/{rating}")
    public MessageResponse rateAppointment(@PathVariable(value = "appointmentId") Integer appointmentId, @PathVariable(value = "rating") Integer rating){
        appointmentWithoutRatingService.rateAppointment(appointmentId,rating);
        return new MessageResponse("Item has been saved successfully");
    }


    @Override
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public ResponseEntity<AppointmentWithoutRatingDto> update(@RequestBody AppointmentWithoutRatingDto dto){
        System.out.println("in app controller");
        System.out.println(dto);
        return new ResponseEntity<>(appointmentWithoutRatingService.updateAppointment(dto), HttpStatus.OK);
    }
}
