package gov.iti.jets.clinify.repositories;

import gov.iti.jets.clinify.models.entities.City;
import gov.iti.jets.clinify.models.entities.Clinic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClinicRepository extends BaseRepository<Clinic> {
    public Clinic findByEmailIgnoreCaseAndPassword(String email, String password);

}
