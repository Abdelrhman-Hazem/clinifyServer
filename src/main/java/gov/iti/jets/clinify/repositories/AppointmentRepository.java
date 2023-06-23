package gov.iti.jets.clinify.repositories;

import gov.iti.jets.clinify.models.entities.Appointment;

import java.sql.Timestamp;
import java.util.List;

public interface AppointmentRepository extends BaseRepository<Appointment> {
    public List<Appointment> findAllByDoctor_Id(Integer doctorId);
    public List<Appointment> findAllByPatient_Id(Integer doctorId);

    public List<Appointment> findAllByDoctor_IdAndDateGreaterThan(Integer doctorId, Timestamp timestamp);

}
