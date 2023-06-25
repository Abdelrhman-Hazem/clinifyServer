package gov.iti.jets.clinify.repositories;

import gov.iti.jets.clinify.models.entities.Area;
import gov.iti.jets.clinify.repositories.BaseRepository;

import java.util.List;

public interface AreaRepository extends BaseRepository<Area> {

    List<Area> findAllByCity_Id(Integer cityId);
}
