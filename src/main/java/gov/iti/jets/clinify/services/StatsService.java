package gov.iti.jets.clinify.services;

import gov.iti.jets.clinify.models.dtos.StatsDto;
import gov.iti.jets.clinify.repositories.CityRepository;
import gov.iti.jets.clinify.repositories.DoctorRepository;
import gov.iti.jets.clinify.repositories.DoctorSpecializationRepository;
import gov.iti.jets.clinify.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StatsService {
    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private DoctorSpecializationRepository specialityRepository;

    @Autowired
    private CityRepository cityRepository;

    public StatsDto getStats() {
        StatsDto statsDTO = new StatsDto();
        statsDTO.setTotalDoctorCount(doctorRepository.count());
        statsDTO.setTotalPatientCount(patientRepository.count());
        statsDTO.setTotalSpecialityCount(specialityRepository.count());
        statsDTO.setTotalCityCount(cityRepository.count());
        return statsDTO;
    }

}
