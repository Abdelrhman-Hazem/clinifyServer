package gov.iti.jets.clinify.mappers;

import gov.iti.jets.clinify.models.dtos.PatientDto;
import gov.iti.jets.clinify.models.entities.Patient;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING, uses = {AreaSimpleMapper.class, CitySimpleMapper.class, PatientDocumentMapper.class, AppointmentMapper.class})
public interface PatientMapper {
    Patient toEntity(PatientDto patientDto);

    @AfterMapping
    default void linkPatientDocuments(@MappingTarget Patient patient) {
        patient.getPatientDocuments().forEach(patientDocument -> patientDocument.setPatient(patient));
    }

    @AfterMapping
    default void linkAppointments(@MappingTarget Patient patient) {
        patient.getAppointments().forEach(appointment -> appointment.setPatient(patient));
    }

    PatientDto toDto(Patient patient);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Patient partialUpdate(PatientDto patientDto, @MappingTarget Patient patient);
}