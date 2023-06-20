package gov.iti.jets.clinify.services;

import gov.iti.jets.clinify.mappers.BaseMapper;
import gov.iti.jets.clinify.models.dtos.BaseDto;
import gov.iti.jets.clinify.models.entities.BaseEntity;
import gov.iti.jets.clinify.models.entities.Doctor;
import gov.iti.jets.clinify.repositories.BaseRepository;
import gov.iti.jets.clinify.utils.PageQueryUtil;
import gov.iti.jets.clinify.utils.PageResult;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface  BaseService<E extends BaseEntity, D extends BaseDto> {

        List<D> findAll();

        D findById(Integer id);

        D save(D entity);

        List<D> saveAll(List<D> entity);

        void delete(D entity);

        void deleteById(Integer id);

        PageResult<D> getDataPage(PageQueryUtil pageUtil);

        PageResult<D> getDataPage(PageQueryUtil pageUtil, String sortField, Sort.Direction sortDirection);

        BaseRepository<E> Repository();
        BaseMapper<E, D> mapper();
}

