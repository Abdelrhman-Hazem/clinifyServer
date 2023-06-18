package gov.iti.jets.clinify.mappers;

import gov.iti.jets.clinify.models.dtos.AreaSimpleDto;
import gov.iti.jets.clinify.models.entities.Area;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-06-18T09:40:26+0200",
    comments = "version: 1.5.4.Final, compiler: Eclipse JDT (IDE) 3.34.0.v20230511-1142, environment: Java 17.0.7 (Eclipse Adoptium)"
)
@Component
public class AreaSimpleMapperImpl implements AreaSimpleMapper {

    @Override
    public Area toEntity(AreaSimpleDto areaSimpleDto) {
        if ( areaSimpleDto == null ) {
            return null;
        }

        Area area = new Area();

        area.setId( areaSimpleDto.getId() );
        area.setName( areaSimpleDto.getName() );

        return area;
    }

    @Override
    public AreaSimpleDto toDto(Area area) {
        if ( area == null ) {
            return null;
        }

        AreaSimpleDto areaSimpleDto = new AreaSimpleDto();

        areaSimpleDto.setId( area.getId() );
        areaSimpleDto.setName( area.getName() );

        return areaSimpleDto;
    }

    @Override
    public Area partialUpdate(AreaSimpleDto areaSimpleDto, Area area) {
        if ( areaSimpleDto == null ) {
            return area;
        }

        if ( areaSimpleDto.getId() != null ) {
            area.setId( areaSimpleDto.getId() );
        }
        if ( areaSimpleDto.getName() != null ) {
            area.setName( areaSimpleDto.getName() );
        }

        return area;
    }
}
