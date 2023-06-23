package gov.iti.jets.clinify.repositories;

import gov.iti.jets.clinify.models.entities.Doctor;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

public class FlexibleDoctorSearchStrategy{
    private final DoctorRepository doctorRepository;

    public FlexibleDoctorSearchStrategy(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    public List<Doctor> search(String name, String area, String specialization) {
        Specification<Doctor> specification = Specification.where(null);

        if (name != null) {
            specification = specification.and(DoctorSpecifications.hasName(name));
        }

        if (area != null) {
            specification = specification.and(DoctorSpecifications.hasArea(area));
        }

        if (specialization != null) {
            specification = specification.and(DoctorSpecifications.hasSpecialization(specialization));
        }

        return doctorRepository.findAll(specification);
    }
}

