package gov.iti.jets.clinify.services;


import gov.iti.jets.clinify.exceptions.ItemNotFoundException;
import gov.iti.jets.clinify.mappers.BaseMapper;
import gov.iti.jets.clinify.models.dtos.BaseDto;
import gov.iti.jets.clinify.models.dtos.DoctorDto;
import gov.iti.jets.clinify.models.entities.BaseEntity;
import gov.iti.jets.clinify.utils.GeneralSearchRequest;
import gov.iti.jets.clinify.utils.PageQueryUtil;
import gov.iti.jets.clinify.utils.PageResult;
import org.mapstruct.factory.Mappers;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toCollection;

@Service
public abstract class BaseServiceImp<E extends BaseEntity, D extends BaseDto> implements BaseService<E, D> {


    @Override
    public List<D> findAll() {
//        List<E> entity =
        List<D> dtos = mapper().toDtos(Repository().findAll());
        return dtos;
    }

    @Override
    public D findById(Integer id) {

        return mapper().toDto(Repository().findById(id).orElseThrow(() -> new ItemNotFoundException(id)));
    }

    @Override
    @Transactional(readOnly = false)
    public D save(D dto) {
        return mapper().toDto(Repository().save(mapper().toEntity(dto)));
    }

    @Override
    @Transactional(readOnly = false)
    public List<D> saveAll(List<D> dtos) {
        return mapper().toDtos(Repository().saveAll(mapper().toEntities(dtos)));
    }

    @Override
    @Transactional(readOnly = false)
    public void delete(D dto) {
        Repository().delete(mapper().toEntity(dto));
    }

    @Override
    public void deleteById(Integer id) {
        Repository().deleteById(id);
    }

    @Override
    public PageResult<D> getDataPage(PageQueryUtil pageUtil) {
        Pageable pageable = PageRequest.of(pageUtil.getPage() -1, pageUtil.getLimit());
        Page<E> page = this.Repository().findAll(pageable);
        PageResult<E> pageResult = new PageResult<E>(page.getContent(), (int) page.getTotalElements(),
                pageUtil.getLimit(), pageUtil.getPage());

        return  (PageResult<D>) mapper().toDtosPage(pageResult);
    }

    @Override
    public PageResult<D> getDataPage(PageQueryUtil pageUtil, @Nullable String sortField, @Nullable Direction sortDirection) {
        Sort sort = sortDirection.equals(Direction.ASC) ? Sort.by(sortField).ascending()
                : Sort.by(sortField).descending();
        Pageable pageable = PageRequest.of(pageUtil.getPage() - 1, pageUtil.getLimit(), sort);
        Page<E> page = this.Repository().findAll(pageable);
        PageResult<E> pageResult = new PageResult<E>(page.getContent(), (int) page.getTotalElements(),
                pageUtil.getLimit(), pageUtil.getPage());
        return  (PageResult<D>) mapper().toDtosPage(pageResult);

    }

    public Sort constructSortObject(GeneralSearchRequest generalSearchRequest, String defaultSortField) {
        if (generalSearchRequest.getSortDirection() == null) {
            return Sort.by(Direction.ASC, defaultSortField);
        }
        return Sort.by(Direction.valueOf(generalSearchRequest.getSortDirection()), generalSearchRequest.getSortBy());
    }

}
