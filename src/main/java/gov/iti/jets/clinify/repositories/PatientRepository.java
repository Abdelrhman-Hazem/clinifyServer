package gov.iti.jets.clinify.repositories;

import gov.iti.jets.clinify.models.entities.Doctor;
import gov.iti.jets.clinify.models.entities.Patient;

public interface PatientRepository extends BaseRepository<Patient> {

    Patient findByPhoneNumber(String phone);

    Patient findByEmail(String email);

}
