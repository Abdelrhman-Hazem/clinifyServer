package gov.iti.jets.clinify.repositories;

import gov.iti.jets.clinify.models.entities.BaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface BaseRepository<E extends BaseEntity> extends JpaRepository<E, Integer> {

}
