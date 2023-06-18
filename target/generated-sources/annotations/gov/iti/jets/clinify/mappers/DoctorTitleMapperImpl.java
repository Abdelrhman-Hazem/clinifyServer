package gov.iti.jets.clinify.mappers;

import gov.iti.jets.clinify.models.dtos.DoctorDto;
import gov.iti.jets.clinify.models.dtos.DoctorTitleDto;
import gov.iti.jets.clinify.models.entities.Doctor;
import gov.iti.jets.clinify.models.entities.DoctorTitle;
import java.util.LinkedHashSet;
import java.util.Set;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-06-18T09:40:27+0200",
    comments = "version: 1.5.4.Final, compiler: Eclipse JDT (IDE) 3.34.0.v20230511-1142, environment: Java 17.0.7 (Eclipse Adoptium)"
)
@Component
public class DoctorTitleMapperImpl implements DoctorTitleMapper {

    @Autowired
    private DoctorMapper doctorMapper;

    @Override
    public DoctorTitle toEntity(DoctorTitleDto doctorTitleDto) {
        if ( doctorTitleDto == null ) {
            return null;
        }

        DoctorTitle doctorTitle = new DoctorTitle();

        doctorTitle.setId( doctorTitleDto.getId() );
        doctorTitle.setName( doctorTitleDto.getName() );
        doctorTitle.setDoctors( doctorDtoSetToDoctorSet( doctorTitleDto.getDoctors() ) );

        linkDoctors( doctorTitle );

        return doctorTitle;
    }

    @Override
    public DoctorTitleDto toDto(DoctorTitle doctorTitle) {
        if ( doctorTitle == null ) {
            return null;
        }

        DoctorTitleDto doctorTitleDto = new DoctorTitleDto();

        doctorTitleDto.setDoctors( doctorSetToDoctorDtoSet( doctorTitle.getDoctors() ) );
        doctorTitleDto.setId( doctorTitle.getId() );
        doctorTitleDto.setName( doctorTitle.getName() );

        return doctorTitleDto;
    }

    @Override
    public DoctorTitle partialUpdate(DoctorTitleDto doctorTitleDto, DoctorTitle doctorTitle) {
        if ( doctorTitleDto == null ) {
            return doctorTitle;
        }

        if ( doctorTitleDto.getId() != null ) {
            doctorTitle.setId( doctorTitleDto.getId() );
        }
        if ( doctorTitleDto.getName() != null ) {
            doctorTitle.setName( doctorTitleDto.getName() );
        }
        if ( doctorTitle.getDoctors() != null ) {
            Set<Doctor> set = doctorDtoSetToDoctorSet( doctorTitleDto.getDoctors() );
            if ( set != null ) {
                doctorTitle.getDoctors().clear();
                doctorTitle.getDoctors().addAll( set );
            }
        }
        else {
            Set<Doctor> set = doctorDtoSetToDoctorSet( doctorTitleDto.getDoctors() );
            if ( set != null ) {
                doctorTitle.setDoctors( set );
            }
        }

        linkDoctors( doctorTitle );

        return doctorTitle;
    }

    protected Set<Doctor> doctorDtoSetToDoctorSet(Set<DoctorDto> set) {
        if ( set == null ) {
            return null;
        }

        Set<Doctor> set1 = new LinkedHashSet<Doctor>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( DoctorDto doctorDto : set ) {
            set1.add( doctorMapper.toEntity( doctorDto ) );
        }

        return set1;
    }

    protected Set<DoctorDto> doctorSetToDoctorDtoSet(Set<Doctor> set) {
        if ( set == null ) {
            return null;
        }

        Set<DoctorDto> set1 = new LinkedHashSet<DoctorDto>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( Doctor doctor : set ) {
            set1.add( doctorMapper.toDto( doctor ) );
        }

        return set1;
    }
}
