package gov.iti.jets.clinify.repositories;

import gov.iti.jets.clinify.models.entities.Patient;

import java.util.Optional;

public interface PatientRepository extends BaseRepository<Patient> {
    Optional<Patient> findByEmailIgnoreCase(String email);
    Optional<Patient> findByPhoneNumber(String phoneNumber);
}
