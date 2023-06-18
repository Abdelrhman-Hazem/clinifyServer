package gov.iti.jets.clinify.mappers;

import gov.iti.jets.clinify.models.dtos.AreaDto;
import gov.iti.jets.clinify.models.dtos.ClinicDto;
import gov.iti.jets.clinify.models.entities.Area;
import gov.iti.jets.clinify.models.entities.City;
import gov.iti.jets.clinify.models.entities.Clinic;
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
public class AreaMapperImpl implements AreaMapper {

    @Autowired
    private CitySimpleMapper citySimpleMapper;
    @Autowired
    private ClinicMapper clinicMapper;

    @Override
    public Area toEntity(AreaDto areaDto) {
        if ( areaDto == null ) {
            return null;
        }

        Area area = new Area();

        area.setId( areaDto.getId() );
        area.setCity( citySimpleMapper.toEntity( areaDto.getCity() ) );
        area.setName( areaDto.getName() );
        area.setClinics( clinicDtoSetToClinicSet( areaDto.getClinics() ) );

        linkClinics( area );

        return area;
    }

    @Override
    public AreaDto toDto(Area area) {
        if ( area == null ) {
            return null;
        }

        AreaDto areaDto = new AreaDto();

        areaDto.setCity( citySimpleMapper.toDto( area.getCity() ) );
        areaDto.setClinics( clinicSetToClinicDtoSet( area.getClinics() ) );
        areaDto.setId( area.getId() );
        areaDto.setName( area.getName() );

        return areaDto;
    }

    @Override
    public Area partialUpdate(AreaDto areaDto, Area area) {
        if ( areaDto == null ) {
            return area;
        }

        if ( areaDto.getId() != null ) {
            area.setId( areaDto.getId() );
        }
        if ( areaDto.getCity() != null ) {
            if ( area.getCity() == null ) {
                area.setCity( new City() );
            }
            citySimpleMapper.partialUpdate( areaDto.getCity(), area.getCity() );
        }
        if ( areaDto.getName() != null ) {
            area.setName( areaDto.getName() );
        }
        if ( area.getClinics() != null ) {
            Set<Clinic> set = clinicDtoSetToClinicSet( areaDto.getClinics() );
            if ( set != null ) {
                area.getClinics().clear();
                area.getClinics().addAll( set );
            }
        }
        else {
            Set<Clinic> set = clinicDtoSetToClinicSet( areaDto.getClinics() );
            if ( set != null ) {
                area.setClinics( set );
            }
        }

        linkClinics( area );

        return area;
    }

    protected Set<Clinic> clinicDtoSetToClinicSet(Set<ClinicDto> set) {
        if ( set == null ) {
            return null;
        }

        Set<Clinic> set1 = new LinkedHashSet<Clinic>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( ClinicDto clinicDto : set ) {
            set1.add( clinicMapper.toEntity( clinicDto ) );
        }

        return set1;
    }

    protected Set<ClinicDto> clinicSetToClinicDtoSet(Set<Clinic> set) {
        if ( set == null ) {
            return null;
        }

        Set<ClinicDto> set1 = new LinkedHashSet<ClinicDto>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( Clinic clinic : set ) {
            set1.add( clinicMapper.toDto( clinic ) );
        }

        return set1;
    }
}
