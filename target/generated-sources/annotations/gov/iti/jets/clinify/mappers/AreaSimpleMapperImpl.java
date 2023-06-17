package gov.iti.jets.clinify.mappers;

import gov.iti.jets.clinify.models.dtos.AreaSimpleDto;
import gov.iti.jets.clinify.models.entities.Area;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-06-16T20:42:29+0200",
    comments = "version: 1.5.4.Final, compiler: javac, environment: Java 17.0.5 (Oracle Corporation)"
)
@Component
public class AreaSimpleMapperImpl implements AreaSimpleMapper {

    @Override
    public Area toEntity(AreaSimpleDto areaSimpleDto) {
        if ( areaSimpleDto == null ) {
            return null;
        }

        Area area = new Area();

        return area;
    }

    @Override
    public AreaSimpleDto toDto(Area area) {
        if ( area == null ) {
            return null;
        }

        AreaSimpleDto areaSimpleDto = new AreaSimpleDto();

        return areaSimpleDto;
    }

    @Override
    public Area partialUpdate(AreaSimpleDto areaSimpleDto, Area area) {
        if ( areaSimpleDto == null ) {
            return area;
        }

        return area;
    }
}
