package gov.iti.jets.clinify.mappers;

import gov.iti.jets.clinify.models.dtos.BaseDto;
import gov.iti.jets.clinify.models.entities.BaseEntity;
import gov.iti.jets.clinify.utils.PageResult;
import org.mapstruct.BeanMapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toCollection;

public interface BaseMapper<E extends BaseEntity, D extends BaseDto> {

    E toEntity(D doctorDto);


    D toDto(E doctor);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    E partialUpdate(D doctorDto, @MappingTarget E doctor);

    default PageResult<D> toDtosPage(PageResult<E> entity){;
        return new PageResult<>(entity.getData().stream().map(this::toDto).collect(toCollection(ArrayList<D>::new)), entity.getTotalCount(), entity.getPageSize(), entity.getCurrPage());
    }


     default  List<D> toDtos(List<E> entities) {
        List<D> dtos = (ArrayList<D>) (entities.stream().map(e->toDto(e)).collect(toCollection(ArrayList<BaseDto>::new)));
        return dtos;
    }

    default  List<E> toEntities(List<D> dtos) {
        List<E> entities = (ArrayList<E>) (dtos.stream().map(d->toEntity(d)).collect(toCollection(ArrayList<BaseEntity>::new)));
        return entities;
    }




}
