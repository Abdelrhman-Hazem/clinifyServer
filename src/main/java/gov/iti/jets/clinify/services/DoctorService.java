package gov.iti.jets.clinify.services;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectInputStream;
import com.amazonaws.util.IOUtils;
import gov.iti.jets.clinify.mappers.BaseMapper;
import gov.iti.jets.clinify.mappers.DoctorMapper;
import gov.iti.jets.clinify.models.dtos.DoctorDto;
import gov.iti.jets.clinify.models.dtos.DoctorSearchDto;
import gov.iti.jets.clinify.models.entities.Doctor;
import gov.iti.jets.clinify.repositories.BaseRepository;
import gov.iti.jets.clinify.repositories.DoctorRepository;
import gov.iti.jets.clinify.utils.PageQueryUtil;
import gov.iti.jets.clinify.utils.PageResult;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.AllArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class DoctorService extends BaseServiceImp<Doctor, DoctorDto> {


    @Autowired
    private  DoctorRepository doctorRepository;

    @Value("${buketName}")
    private String bucketName;

    @Autowired
    private AmazonS3 s3Client;

    @Override
    public BaseRepository<Doctor> Repository() {
        return doctorRepository;
    }

    @Override
    public BaseMapper<Doctor, DoctorDto> mapper() {
        return Mappers.getMapper(DoctorMapper.class);
    }

    public DoctorDto findByPhoneNumber(String phone) {
        return mapper().toDto(doctorRepository.findByPhoneNumber(phone));
    }

    public PageResult<DoctorDto> getDoctorsDataPage(PageQueryUtil pageUtil) {
        Pageable pageable = PageRequest.of(pageUtil.getPage() - 1, pageUtil.getLimit());
        Page<Doctor> page = this.doctorRepository.findAllByIsDeletedIsFalse(pageable);
        PageResult<Doctor> pageResult = new PageResult<Doctor>(page.getContent(), (int) page.getTotalElements(),
                pageUtil.getLimit(), pageUtil.getPage());

        return (PageResult<DoctorDto>) mapper().toDtosPage(pageResult);
    }

    public PageResult<DoctorDto> searchDoctors(DoctorSearchDto doctorSearchDto, PageQueryUtil pageUtil) {
        Pageable pageRequest = PageRequest.of(pageUtil.getPage() - 1, pageUtil.getLimit());
        // Use the repository method with dynamic query creation based on the search criteria
        Page<Doctor> page = doctorRepository.findAll((root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            predicates.add(criteriaBuilder.equal(root.get("isDeleted"), false));

            if (doctorSearchDto != null) {
                if (doctorSearchDto.getSpecialization() != null) {
                    predicates.add(criteriaBuilder.equal(root.get("doctorSpecialization"), doctorSearchDto.getSpecialization()));
                }
                if (doctorSearchDto.getCity() != null) {
                    predicates.add(criteriaBuilder.equal(root.get("clinic").get("city"), doctorSearchDto.getCity()));
                }
                if (doctorSearchDto.getArea() != null) {
                    predicates.add(criteriaBuilder.equal(root.get("clinic").get("area"), doctorSearchDto.getArea()));
                }
                if (doctorSearchDto.getClinicName() != null) {
                    predicates.add(criteriaBuilder.equal(root.get("clinic").get("name"), doctorSearchDto.getClinicName()));
                }
            }
            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        }, pageRequest);

        PageResult<Doctor> pageResult = new PageResult<Doctor>(page.getContent(), (int) page.getTotalElements(),
                pageUtil.getLimit(), pageUtil.getPage());

        return (PageResult<DoctorDto>) mapper().toDtosPage(pageResult);
    }

    public String uploadFile(MultipartFile file) {

            File fileObj = convertMultiPartFileToFile(file);
//            String fileName = System.currentTimeMillis() + "_" + file.getOriginalFilename();
            String fileName =  file.getOriginalFilename();
            String nameOfBucket = this.bucketName;
            s3Client.putObject(new PutObjectRequest(nameOfBucket, fileName, fileObj));
            fileObj.delete();

//        if(selection==Constants.ADS_SEL) {
//            this.sliderService.saveAll(sliders);
//        }
        return "File uploaded successfully";
    }


    public byte[] downloadFile(String fileName) {
        String nameOfBucket= this.bucketName;
        S3Object s3Object = s3Client.getObject(nameOfBucket, fileName);
        S3ObjectInputStream inputStream = s3Object.getObjectContent();
        try {
            byte[] content = IOUtils.toByteArray(inputStream);
            return content;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }



    private File convertMultiPartFileToFile(MultipartFile file) {
        File convertedFile = new File(file.getOriginalFilename());
        try (FileOutputStream fos = new FileOutputStream(convertedFile)) {
            fos.write(file.getBytes());
        } catch (IOException e) {
//            log.error("Error converting multipartFile to file", e);
        }
        return convertedFile;
    }

}
