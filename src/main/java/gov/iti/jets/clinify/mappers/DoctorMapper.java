package gov.iti.jets.clinify.mappers;

import gov.iti.jets.clinify.models.dtos.DoctorDto;
import gov.iti.jets.clinify.models.entities.Doctor;
import gov.iti.jets.clinify.utils.PageResult;
import org.mapstruct.*;

import java.util.ArrayList;

import static java.util.stream.Collectors.toCollection;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface DoctorMapper extends BaseMapper<Doctor, DoctorDto> {
    @AfterMapping
    default void linkAppointments(@MappingTarget Doctor doctor) {
        doctor.getAppointments().forEach(appointment -> appointment.setDoctor(doctor));
    }

}
