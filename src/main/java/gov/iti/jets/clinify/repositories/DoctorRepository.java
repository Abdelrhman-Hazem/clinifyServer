package gov.iti.jets.clinify.repositories;

import gov.iti.jets.clinify.models.entities.Clinic;
import gov.iti.jets.clinify.models.entities.Doctor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface DoctorRepository extends BaseRepository<Doctor> , JpaSpecificationExecutor<Doctor> {
    List<Doctor> findByClinic_City_Id(Integer cityId);
    List<Doctor> findByClinic_Area_Id(Integer areaId);
//    List<Doctor> findByClinic_City_IdAndAndDoctorSpecialization

    Page<Doctor> findAllByIsDeletedIsFalse(Pageable pageable);

    Doctor findByPhoneNumber(String phone);

    List<Doctor> findAllByStatusIgnoreCase(String status);

    Page<Doctor> findAllByClinic_Id(Pageable pageable, Integer clinicId);



}
