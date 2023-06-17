package gov.iti.jets.clinify.mappers;

import gov.iti.jets.clinify.models.dtos.DoctorTitleSimpleDto;
import gov.iti.jets.clinify.models.entities.DoctorTitle;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-06-16T20:42:29+0200",
    comments = "version: 1.5.4.Final, compiler: javac, environment: Java 17.0.5 (Oracle Corporation)"
)
@Component
public class DoctorTitleSimpleMapperImpl implements DoctorTitleSimpleMapper {

    @Override
    public DoctorTitle toEntity(DoctorTitleSimpleDto doctorTitleSimpleDto) {
        if ( doctorTitleSimpleDto == null ) {
            return null;
        }

        DoctorTitle doctorTitle = new DoctorTitle();

        return doctorTitle;
    }

    @Override
    public DoctorTitleSimpleDto toDto(DoctorTitle doctorTitle) {
        if ( doctorTitle == null ) {
            return null;
        }

        DoctorTitleSimpleDto doctorTitleSimpleDto = new DoctorTitleSimpleDto();

        return doctorTitleSimpleDto;
    }

    @Override
    public DoctorTitle partialUpdate(DoctorTitleSimpleDto doctorTitleSimpleDto, DoctorTitle doctorTitle) {
        if ( doctorTitleSimpleDto == null ) {
            return doctorTitle;
        }

        return doctorTitle;
    }
}
