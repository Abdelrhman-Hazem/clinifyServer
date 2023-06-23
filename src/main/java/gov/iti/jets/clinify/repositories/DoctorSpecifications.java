package gov.iti.jets.clinify.repositories;

import gov.iti.jets.clinify.models.entities.Doctor;
import org.springframework.data.jpa.domain.Specification;

public class DoctorSpecifications {
    public static Specification<Doctor> hasName(String name) {
        return (root, query, builder) -> builder.like(builder.lower(root.get("name")), "%" + name.toLowerCase() + "%");
    }

    public static Specification<Doctor> hasArea(String area) {
        return (root, query, builder) -> builder.like(builder.lower(root.get("area")), "=" + area );
    }
    public static Specification<Doctor> hasCity(String area) {
        return (root, query, builder) -> builder.like(builder.lower(root.get("area")), "=" + area );
    }

    public static Specification<Doctor> hasSpecialization(String specialization) {
        return (root, query, builder) -> builder.like(builder.lower(root.get("specialization")), "=" + specialization );
    }
}

