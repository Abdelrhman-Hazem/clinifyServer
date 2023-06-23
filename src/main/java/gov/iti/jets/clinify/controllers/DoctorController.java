package gov.iti.jets.clinify.controllers;

import gov.iti.jets.clinify.exceptions.FieldNotUniqueException;
import gov.iti.jets.clinify.mappers.DoctorMapper;
import gov.iti.jets.clinify.models.dtos.DoctorDto;
import gov.iti.jets.clinify.models.dtos.DoctorSearchDto;
import gov.iti.jets.clinify.models.entities.Area;
import gov.iti.jets.clinify.models.entities.City;
import gov.iti.jets.clinify.models.entities.Doctor;
import gov.iti.jets.clinify.models.entities.DoctorSpecialization;
import gov.iti.jets.clinify.services.DoctorService;
import gov.iti.jets.clinify.utils.MessageResponse;
import gov.iti.jets.clinify.utils.PageQueryUtil;
import gov.iti.jets.clinify.utils.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/doctors")
@CrossOrigin
public class DoctorController extends BaseController<Doctor, DoctorDto> {

    @Autowired
    private DoctorService doctorService;


    @PostMapping( "/addDoctor")
    public ResponseEntity<MessageResponse> addDoctor(@RequestBody DoctorDto dto) {
        DoctorDto doctorDto = this.doctorService.findByPhoneNumber(dto.getPhoneNumber());
        if(doctorDto != null && !doctorDto.getId().equals(dto.getId())){
            throw new FieldNotUniqueException("phoneNumber", "Already Exists");
        }
        doctorService.save(dto);
        return new ResponseEntity<>(new MessageResponse("Doctor Added Successfully"), HttpStatus.OK);
    }

    @PutMapping( "/updateDoctor")
    public ResponseEntity<MessageResponse> updateDoctor(@RequestBody DoctorDto dto) {
        DoctorDto doctorDto = this.doctorService.findByPhoneNumber(dto.getPhoneNumber());
        if(doctorDto != null && !doctorDto.getId().equals(dto.getId())){
            throw new FieldNotUniqueException("phoneNumber", "Already Exists");
        }
        doctorService.save(dto);
        return new ResponseEntity<>(new MessageResponse("Doctor Updated Successfully"), HttpStatus.OK);
    }

    @Override
    @RequestMapping(value="/getPage", method = RequestMethod.GET)
    public PageResult<DoctorDto> getDataPage(@RequestParam int page, @RequestParam int limit) {
        PageQueryUtil queryUtil = new PageQueryUtil(page, limit);
        return doctorService.getDoctorsDataPage(queryUtil);
    }
        @RequestMapping(value="{specialityId}/{cityId}/{areaId}", method = RequestMethod.GET)
        // @RequestMapping (value="/searchResult" , method=RequestMethod.GET)
    public PageResult<DoctorDto> filterDoctors(@PathVariable String specialityId,@PathVariable String cityId,@PathVariable String areaId,@RequestParam int page,
                                 @RequestParam int limit,@RequestParam String clinicName) {
        PageQueryUtil queryUtil = new PageQueryUtil(page, limit);
        DoctorSearchDto doctorSearchDto = new DoctorSearchDto();
        DoctorSpecialization specialization = new DoctorSpecialization();
     
        
        if(!cityId.equals("null")){
        City city=new City();
        city.setId(Integer.parseInt(cityId));
        doctorSearchDto.setCity(city);
        }
        if(!areaId.equals("null")){
            Area area = new Area();
            area.setId(Integer.parseInt(areaId));
            doctorSearchDto.setArea(area);
        }
        if(!specialityId.equals("null")){
             specialization.setId(Integer.parseInt(specialityId));
              doctorSearchDto.setSpecialization(specialization);
        }
        
       if(!clinicName.equals("null")){
        doctorSearchDto.setClinicName(clinicName);
       }
        
        return doctorService.searchDoctors(doctorSearchDto, queryUtil);
    } 

}
