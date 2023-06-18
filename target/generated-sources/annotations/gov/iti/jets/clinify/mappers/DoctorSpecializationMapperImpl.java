package gov.iti.jets.clinify.mappers;

import gov.iti.jets.clinify.models.dtos.DoctorDto;
import gov.iti.jets.clinify.models.dtos.DoctorSpecializationDto;
import gov.iti.jets.clinify.models.entities.Doctor;
import gov.iti.jets.clinify.models.entities.DoctorSpecialization;
import java.util.LinkedHashSet;
import java.util.Set;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-06-18T09:40:26+0200",
    comments = "version: 1.5.4.Final, compiler: Eclipse JDT (IDE) 3.34.0.v20230511-1142, environment: Java 17.0.7 (Eclipse Adoptium)"
)
@Component
public class DoctorSpecializationMapperImpl implements DoctorSpecializationMapper {

    @Autowired
    private DoctorMapper doctorMapper;

    @Override
    public DoctorSpecialization toEntity(DoctorSpecializationDto doctorSpecializationDto) {
        if ( doctorSpecializationDto == null ) {
            return null;
        }

        DoctorSpecialization doctorSpecialization = new DoctorSpecialization();

        doctorSpecialization.setId( doctorSpecializationDto.getId() );
        doctorSpecialization.setName( doctorSpecializationDto.getName() );
        doctorSpecialization.setDoctors( doctorDtoSetToDoctorSet( doctorSpecializationDto.getDoctors() ) );

        linkDoctors( doctorSpecialization );

        return doctorSpecialization;
    }

    @Override
    public DoctorSpecializationDto toDto(DoctorSpecialization doctorSpecialization) {
        if ( doctorSpecialization == null ) {
            return null;
        }

        DoctorSpecializationDto doctorSpecializationDto = new DoctorSpecializationDto();

        doctorSpecializationDto.setDoctors( doctorSetToDoctorDtoSet( doctorSpecialization.getDoctors() ) );
        doctorSpecializationDto.setId( doctorSpecialization.getId() );
        doctorSpecializationDto.setName( doctorSpecialization.getName() );

        return doctorSpecializationDto;
    }

    @Override
    public DoctorSpecialization partialUpdate(DoctorSpecializationDto doctorSpecializationDto, DoctorSpecialization doctorSpecialization) {
        if ( doctorSpecializationDto == null ) {
            return doctorSpecialization;
        }

        if ( doctorSpecializationDto.getId() != null ) {
            doctorSpecialization.setId( doctorSpecializationDto.getId() );
        }
        if ( doctorSpecializationDto.getName() != null ) {
            doctorSpecialization.setName( doctorSpecializationDto.getName() );
        }
        if ( doctorSpecialization.getDoctors() != null ) {
            Set<Doctor> set = doctorDtoSetToDoctorSet( doctorSpecializationDto.getDoctors() );
            if ( set != null ) {
                doctorSpecialization.getDoctors().clear();
                doctorSpecialization.getDoctors().addAll( set );
            }
        }
        else {
            Set<Doctor> set = doctorDtoSetToDoctorSet( doctorSpecializationDto.getDoctors() );
            if ( set != null ) {
                doctorSpecialization.setDoctors( set );
            }
        }

        linkDoctors( doctorSpecialization );

        return doctorSpecialization;
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
