package gov.iti.jets.clinify.mappers;

import gov.iti.jets.clinify.models.dtos.ClinicDto;
import gov.iti.jets.clinify.models.dtos.DoctorDto;
import gov.iti.jets.clinify.models.entities.Area;
import gov.iti.jets.clinify.models.entities.City;
import gov.iti.jets.clinify.models.entities.Clinic;
import gov.iti.jets.clinify.models.entities.Doctor;
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
public class ClinicMapperImpl implements ClinicMapper {

    @Autowired
    private AreaSimpleMapper areaSimpleMapper;
    @Autowired
    private CitySimpleMapper citySimpleMapper;
    @Autowired
    private DoctorMapper doctorMapper;

    @Override
    public Clinic toEntity(ClinicDto clinicDto) {
        if ( clinicDto == null ) {
            return null;
        }

        Clinic clinic = new Clinic();

        clinic.setId( clinicDto.getId() );
        clinic.setArea( areaSimpleMapper.toEntity( clinicDto.getArea() ) );
        clinic.setCity( citySimpleMapper.toEntity( clinicDto.getCity() ) );
        clinic.setUsername( clinicDto.getUsername() );
        clinic.setPassword( clinicDto.getPassword() );
        clinic.setName( clinicDto.getName() );
        clinic.setPhoneNumber( clinicDto.getPhoneNumber() );
        clinic.setEmail( clinicDto.getEmail() );
        clinic.setAddress( clinicDto.getAddress() );
        clinic.setStatus( clinicDto.getStatus() );
        clinic.setIsDeleted( clinicDto.getIsDeleted() );
        clinic.setDoctors( doctorDtoSetToDoctorSet( clinicDto.getDoctors() ) );

        linkDoctors( clinic );

        return clinic;
    }

    @Override
    public ClinicDto toDto(Clinic clinic) {
        if ( clinic == null ) {
            return null;
        }

        ClinicDto clinicDto = new ClinicDto();

        clinicDto.setAddress( clinic.getAddress() );
        clinicDto.setArea( areaSimpleMapper.toDto( clinic.getArea() ) );
        clinicDto.setCity( citySimpleMapper.toDto( clinic.getCity() ) );
        clinicDto.setDoctors( doctorSetToDoctorDtoSet( clinic.getDoctors() ) );
        clinicDto.setEmail( clinic.getEmail() );
        clinicDto.setId( clinic.getId() );
        clinicDto.setIsDeleted( clinic.getIsDeleted() );
        clinicDto.setName( clinic.getName() );
        clinicDto.setPassword( clinic.getPassword() );
        clinicDto.setPhoneNumber( clinic.getPhoneNumber() );
        clinicDto.setStatus( clinic.getStatus() );
        clinicDto.setUsername( clinic.getUsername() );

        return clinicDto;
    }

    @Override
    public Clinic partialUpdate(ClinicDto clinicDto, Clinic clinic) {
        if ( clinicDto == null ) {
            return clinic;
        }

        if ( clinicDto.getId() != null ) {
            clinic.setId( clinicDto.getId() );
        }
        if ( clinicDto.getArea() != null ) {
            if ( clinic.getArea() == null ) {
                clinic.setArea( new Area() );
            }
            areaSimpleMapper.partialUpdate( clinicDto.getArea(), clinic.getArea() );
        }
        if ( clinicDto.getCity() != null ) {
            if ( clinic.getCity() == null ) {
                clinic.setCity( new City() );
            }
            citySimpleMapper.partialUpdate( clinicDto.getCity(), clinic.getCity() );
        }
        if ( clinicDto.getUsername() != null ) {
            clinic.setUsername( clinicDto.getUsername() );
        }
        if ( clinicDto.getPassword() != null ) {
            clinic.setPassword( clinicDto.getPassword() );
        }
        if ( clinicDto.getName() != null ) {
            clinic.setName( clinicDto.getName() );
        }
        if ( clinicDto.getPhoneNumber() != null ) {
            clinic.setPhoneNumber( clinicDto.getPhoneNumber() );
        }
        if ( clinicDto.getEmail() != null ) {
            clinic.setEmail( clinicDto.getEmail() );
        }
        if ( clinicDto.getAddress() != null ) {
            clinic.setAddress( clinicDto.getAddress() );
        }
        if ( clinicDto.getStatus() != null ) {
            clinic.setStatus( clinicDto.getStatus() );
        }
        if ( clinicDto.getIsDeleted() != null ) {
            clinic.setIsDeleted( clinicDto.getIsDeleted() );
        }
        if ( clinic.getDoctors() != null ) {
            Set<Doctor> set = doctorDtoSetToDoctorSet( clinicDto.getDoctors() );
            if ( set != null ) {
                clinic.getDoctors().clear();
                clinic.getDoctors().addAll( set );
            }
        }
        else {
            Set<Doctor> set = doctorDtoSetToDoctorSet( clinicDto.getDoctors() );
            if ( set != null ) {
                clinic.setDoctors( set );
            }
        }

        linkDoctors( clinic );

        return clinic;
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
