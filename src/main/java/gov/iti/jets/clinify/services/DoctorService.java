package gov.iti.jets.clinify.services;

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
import lombok.AllArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
@Service
public class DoctorService extends BaseServiceImp<Doctor, DoctorDto>{

    @PersistenceContext
    private EntityManager entityManager;

    private final DoctorRepository doctorRepository;

    @Override
    public BaseRepository<Doctor> Repository() {
        return doctorRepository;
    }

    @Override
    public BaseMapper<Doctor, DoctorDto> mapper(){
        return Mappers.getMapper(DoctorMapper.class);
    }

    public DoctorDto findByPhoneNumber(String phone){
        return mapper().toDto(doctorRepository.findByPhoneNumber(phone));
    }

    public PageResult<DoctorDto> getDoctorsDataPage(PageQueryUtil pageUtil) {
        Pageable pageable = PageRequest.of(pageUtil.getPage() -1, pageUtil.getLimit());
        Page<Doctor> page = this.doctorRepository.findAllByIsDeletedIsFalse(pageable);
        PageResult<Doctor> pageResult = new PageResult<Doctor>(page.getContent(), (int) page.getTotalElements(),
                pageUtil.getLimit(), pageUtil.getPage());

        return  (PageResult<DoctorDto>) mapper().toDtosPage(pageResult);
    }

    

}
