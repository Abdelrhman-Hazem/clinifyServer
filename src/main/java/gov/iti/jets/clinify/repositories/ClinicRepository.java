package gov.iti.jets.clinify.repositories;

import gov.iti.jets.clinify.models.entities.City;
import gov.iti.jets.clinify.models.entities.Clinic;
import gov.iti.jets.clinify.models.entities.Doctor;
import gov.iti.jets.clinify.models.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ClinicRepository extends BaseRepository<Clinic> {
    public Clinic findByEmailIgnoreCaseAndPassword(String email, String password);
    Optional<Clinic> findByEmailIgnoreCase(String email);
    Optional<Clinic> findByPhoneNumber(String phoneNumber);
    List<Clinic> findByStatus(String status);
}
