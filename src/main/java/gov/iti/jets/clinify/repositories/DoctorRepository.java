package gov.iti.jets.clinify.repositories;

import com.fasterxml.jackson.databind.ser.Serializers;
import gov.iti.jets.clinify.models.dtos.DoctorDto;
import gov.iti.jets.clinify.models.entities.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface DoctorRepository extends BaseRepository<Doctor> , JpaSpecificationExecutor<Doctor> {
    List<Doctor> findByClinic_City_Id(Integer cityId);
    List<Doctor> findByClinic_Area_Id(Integer areaId);
//    List<Doctor> findByClinic_City_IdAndAndDoctorSpecialization

    Doctor findByPhoneNumber(String phone);
}
