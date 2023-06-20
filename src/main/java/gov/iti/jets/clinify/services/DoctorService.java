package gov.iti.jets.clinify.services;

import gov.iti.jets.clinify.mappers.BaseMapper;
import gov.iti.jets.clinify.mappers.DoctorMapper;
import gov.iti.jets.clinify.models.dtos.DoctorDto;
import gov.iti.jets.clinify.models.entities.Doctor;
import gov.iti.jets.clinify.repositories.BaseRepository;
import gov.iti.jets.clinify.repositories.DoctorRepository;
import lombok.AllArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class DoctorService extends BaseServiceImp<Doctor, DoctorDto>{

    private final DoctorRepository doctorRepository;

    @Override
    public BaseRepository<Doctor> Repository() {
        return doctorRepository;
    }

    @Override
    public BaseMapper<Doctor, DoctorDto> mapper(){
        return Mappers.getMapper(DoctorMapper.class);
    }

}
