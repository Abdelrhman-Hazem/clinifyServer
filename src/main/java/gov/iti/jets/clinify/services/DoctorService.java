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
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.AllArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
@Service
public class DoctorService extends BaseServiceImp<Doctor, DoctorDto> {

    @PersistenceContext
    private EntityManager entityManager;

    private final DoctorRepository doctorRepository;

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

}
