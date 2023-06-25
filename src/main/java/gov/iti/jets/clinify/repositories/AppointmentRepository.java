package gov.iti.jets.clinify.repositories;

import gov.iti.jets.clinify.models.entities.Appointment;

import java.sql.Timestamp;
import java.util.List;

public interface AppointmentRepository extends BaseRepository<Appointment> {
    public List<Appointment> findAllByPatient_IdOrderByDate(Integer doctorId);
//    public List<Appointment> findAllByDoctor_IdAndFullAppointmentNotNullOrderByDate(Integer doctorId);
    public List<Appointment> findAllByDoctor_IdAndFullAppointmentNotNullAndDoctor_IsDeletedIsFalseOrderByDate(Integer doctorId);
    public List<Appointment> findAllByDoctor_IdAndFullAppointmentNullOrderByDate(Integer doctorId);

//    public List<Appointment> findAllByDoctor_IdAndDateGreaterThanAndFullAppointmentNotNullOrderByDate(Integer doctorId, Timestamp timestamp);
    public List<Appointment> findAllByDoctor_IdAndDateGreaterThanAndFullAppointmentNotNullAndDoctor_IsDeletedIsFalseOrderByDate(Integer doctorId, Timestamp timestamp);
    public List<Appointment> findAllByDoctor_IdAndDateGreaterThanAndFullAppointmentNullOrderByDate(Integer doctorId, Timestamp timestamp);

    public List<Appointment> findAllByDoctor_Clinic_IdAndPatientNotNull(Integer clinicId);

//    public List<Appointment> findAllByDoctor_IdAndDateGreaterThan(Integer doctorId, Timestamp timestamp);

}
