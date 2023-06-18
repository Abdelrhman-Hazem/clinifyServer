package gov.iti.jets.clinify.mappers;

import gov.iti.jets.clinify.models.dtos.DoctorTitleSimpleDto;
import gov.iti.jets.clinify.models.entities.DoctorTitle;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-06-18T09:40:26+0200",
    comments = "version: 1.5.4.Final, compiler: Eclipse JDT (IDE) 3.34.0.v20230511-1142, environment: Java 17.0.7 (Eclipse Adoptium)"
)
@Component
public class DoctorTitleSimpleMapperImpl implements DoctorTitleSimpleMapper {

    @Override
    public DoctorTitle toEntity(DoctorTitleSimpleDto doctorTitleSimpleDto) {
        if ( doctorTitleSimpleDto == null ) {
            return null;
        }

        DoctorTitle doctorTitle = new DoctorTitle();

        doctorTitle.setId( doctorTitleSimpleDto.getId() );
        doctorTitle.setName( doctorTitleSimpleDto.getName() );

        return doctorTitle;
    }

    @Override
    public DoctorTitleSimpleDto toDto(DoctorTitle doctorTitle) {
        if ( doctorTitle == null ) {
            return null;
        }

        DoctorTitleSimpleDto doctorTitleSimpleDto = new DoctorTitleSimpleDto();

        doctorTitleSimpleDto.setId( doctorTitle.getId() );
        doctorTitleSimpleDto.setName( doctorTitle.getName() );

        return doctorTitleSimpleDto;
    }

    @Override
    public DoctorTitle partialUpdate(DoctorTitleSimpleDto doctorTitleSimpleDto, DoctorTitle doctorTitle) {
        if ( doctorTitleSimpleDto == null ) {
            return doctorTitle;
        }

        if ( doctorTitleSimpleDto.getId() != null ) {
            doctorTitle.setId( doctorTitleSimpleDto.getId() );
        }
        if ( doctorTitleSimpleDto.getName() != null ) {
            doctorTitle.setName( doctorTitleSimpleDto.getName() );
        }

        return doctorTitle;
    }
}
