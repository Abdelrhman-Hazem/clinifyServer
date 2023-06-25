package gov.iti.jets.clinify.controllers;

import gov.iti.jets.clinify.exceptions.FieldNotUniqueException;
import gov.iti.jets.clinify.mappers.DoctorMapper;
import gov.iti.jets.clinify.models.dtos.ClinicDto;
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
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import static java.nio.file.Files.copy;
import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;


@RestController
@RequestMapping("/doctors")
@CrossOrigin
public class DoctorController extends BaseController<Doctor, DoctorDto> {

    @Autowired
    private DoctorService doctorService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping( "/addDoctor")
    public ResponseEntity<MessageResponse> addDoctor(@RequestBody DoctorDto dto) {
        DoctorDto doctorDto = this.doctorService.findByPhoneNumber(dto.getPhoneNumber());
        if(doctorDto != null && !doctorDto.getId().equals(dto.getId())){
            throw new FieldNotUniqueException("phoneNumber", "Already Exists");
        }

        //Hashing password
        String hashedPassword = passwordEncoder.encode(dto.getClinic().getPassword());
        dto.getClinic().setPassword(hashedPassword);

        DoctorDto savedDto  = doctorService.saveDoctor(dto);
        return new ResponseEntity<>(new MessageResponse(savedDto.getImgUrl()), HttpStatus.OK);
    }

    @PutMapping( "/updateDoctor")
    public ResponseEntity<MessageResponse> updateDoctor(@RequestBody DoctorDto dto) {
        DoctorDto doctorDto = this.doctorService.findByPhoneNumber(dto.getPhoneNumber());
        if(doctorDto != null && !doctorDto.getId().equals(dto.getId())){
            throw new FieldNotUniqueException("phoneNumber", "Already Exists");
        }
        DoctorDto savedDto = doctorService.saveDoctor(dto);
        return new ResponseEntity<>(new MessageResponse(savedDto.getImgUrl()), HttpStatus.OK);
    }

    @RequestMapping(value="/getPage2", method = RequestMethod.GET)
    public PageResult<DoctorDto> getDataPage2(@RequestParam int page, @RequestParam int limit) {
        PageQueryUtil queryUtil = new PageQueryUtil(page, limit);
        return doctorService.getDoctorsDataPage(queryUtil);
    }
    @RequestMapping(value = "{specialityId}/{cityId}/{areaId}", method = RequestMethod.GET)
    // @RequestMapping (value="/searchResult" , method=RequestMethod.GET)
    public PageResult<DoctorDto> filterDoctors(@PathVariable String specialityId, @PathVariable String cityId, @PathVariable String areaId, @RequestParam int page,
                                               @RequestParam int limit, @RequestParam String clinicName, @RequestParam(name = "sortType",required = false) String sort,
                                               @RequestParam(name = "order",required = false) String order) {
        PageQueryUtil queryUtil = new PageQueryUtil(page, limit);
        DoctorSearchDto doctorSearchDto = new DoctorSearchDto();
        DoctorSpecialization specialization = new DoctorSpecialization();


        if (!cityId.equals("null")) {
            City city = new City();
            city.setId(Integer.parseInt(cityId));
            doctorSearchDto.setCity(city);
        }
        if (!areaId.equals("null")) {
            Area area = new Area();
            area.setId(Integer.parseInt(areaId));
            doctorSearchDto.setArea(area);
        }
        if (!specialityId.equals("null")) {
            specialization.setId(Integer.parseInt(specialityId));
            doctorSearchDto.setSpecialization(specialization);
        }

        if (!clinicName.equals("null")) {
            doctorSearchDto.setClinicName(clinicName);
        }

        if (sort != null && !sort.equals("null")) {
            doctorSearchDto.setSortBy(sort);
        }

        if (order != null && !order.equals("null")) {
            doctorSearchDto.setSortDirection(order);
        }

        return doctorService.searchDoctors(doctorSearchDto, queryUtil);
    }

//    @PostMapping("/upload")
//    public ResponseEntity<List<String>> uploadFiles(@RequestParam("files")List<MultipartFile> multipartFiles) throws IOException {
//        Resource resource = resourceLoader.getResource("classpath:filename.txt");
//
//        System.out.println("hiii");
//        List<String> filenames = new ArrayList<>();
//        for(MultipartFile file : multipartFiles) {
//            String filename = StringUtils.cleanPath(Objects.requireNonNull(file.getOriginalFilename()));
//            Path fileStorage = Paths.get(DIRECTORY, filename).toAbsolutePath().normalize();
//            copy(file.getInputStream(), fileStorage, REPLACE_EXISTING);
//            filenames.add(filename);
//        }
//        return ResponseEntity.ok().body(filenames);
//    }
//
//    @GetMapping("/download/{filename}")
//    public ResponseEntity<Resource> downloadFiles(@PathVariable("filename") String filename) throws IOException {
//        Path filePath = Paths.get(DIRECTORY).toAbsolutePath().normalize().resolve(filename);
//        if(!Files.exists(filePath)) {
//            throw new FileNotFoundException(filename + " was not found on the server");
//        }
//        Resource resource = new UrlResource(filePath.toUri());
//        return new ResponseEntity<>(resource,HttpStatus.OK);
//    }


    @PostMapping("/upload")
    public ResponseEntity<MessageResponse> uploadFile(@RequestBody MultipartFile file ) {
        return new ResponseEntity<>(new MessageResponse(doctorService.uploadFile(file)) , HttpStatus.OK);
    }

    @GetMapping("/download/{fileName}")
    public ResponseEntity<ByteArrayResource> downloadFile(@PathVariable String fileName) {
        try {
            byte[] data = doctorService.downloadFile(fileName);
            ByteArrayResource resource = new ByteArrayResource(data);
            return ResponseEntity
                    .ok()
                    .contentLength(data.length)
                    .header("Content-type", "application/octet-stream")
                    .header("Content-disposition", "attachment; filename=\"" + fileName + "\"")
                    .body(resource);
        }catch (Exception ex){
//            log.info(ex.getMessage());
            return null ;
        }
    }

    @GetMapping(value = "/allPending")
    public List<DoctorDto> getAllPending(){
        return doctorService.findAllPending();
    }

    @GetMapping(value = "allByClinicId/{id}")
    public PageResult<DoctorDto> getDoctorsByClinicIdPaged(@RequestParam int page, @RequestParam int limit, @PathVariable(value = "id") Integer clinicId){
        PageQueryUtil queryUtil = new PageQueryUtil(page, limit);
        return doctorService.findAllByClinicId(queryUtil, clinicId);
    }

}
