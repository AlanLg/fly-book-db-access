package com.flybook.service;

import com.flybook.exceptions.FlybookException;
import com.flybook.mapper.AirplaneMapper;
import com.flybook.mapper.AirportMapper;
import com.flybook.model.dto.AirplaneDTO;
import com.flybook.model.dto.AirportDTO;
import com.flybook.model.entity.Airplane;
import com.flybook.model.entity.Airport;
import com.flybook.repository.AirplaneRepository;
import com.flybook.repository.AirportRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AirportService {

    private final AirportRepository airportRepository;

    public AirportDTO findById(Long id) {
        return airportRepository.findById(id)
                .map(AirportMapper.INSTANCE::airportEntityToAirportDTO)
                .orElse(null);
    }

    public List<AirportDTO> findAll() {
        return airportRepository.findAll().stream()
                .map(AirportMapper.INSTANCE::airportEntityToAirportDTO)
                .toList();
    }

    public AirportDTO saveAirport(AirportDTO airportDTO) {
        Airport airport = AirportMapper.INSTANCE.airportDTOToAirportEntity(airportDTO);
        return AirportMapper.INSTANCE.airportEntityToAirportDTO(airportRepository.save(airport));
    }

    public AirportDTO findByAirportName(String airportName) {
        return airportRepository.findByAirportName(airportName)
                .map(AirportMapper.INSTANCE::airportEntityToAirportDTO)
                .orElse(null);
    }

    public void deleteAirport(Long id) {
        airportRepository.deleteById(id);
    }
}
