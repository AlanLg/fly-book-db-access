package com.flybook.service;

import com.flybook.mapper.AirplaneMapper;
import com.flybook.mapper.AirportMapper;
import com.flybook.mapper.FlightMapper;
import com.flybook.model.dto.AirplaneDTO;
import com.flybook.model.dto.FlightDTO;
import com.flybook.model.entity.Airplane;
import com.flybook.model.entity.Flight;
import com.flybook.repository.AirplaneRepository;
import com.flybook.repository.FlightRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FlightService {

    private final FlightRepository flightRepository;

    public FlightDTO findById(Long id) {
        return flightRepository.findById(id)
                .map(FlightMapper.INSTANCE::flightEntityToFlightDTO)
                .orElse(null);
    }

    public FlightDTO findByDepartureAirportAndArrivalAirport(String departureAirport, String arrivalAirport) {
        return flightRepository.findByDepartureAirport_AirportNameAndArrivalAirport_AirportName(departureAirport, arrivalAirport)
                .map(FlightMapper.INSTANCE::flightEntityToFlightDTO)
                .orElse(null);
    }

    public FlightDTO saveFlight(FlightDTO flightDTO) {
        Flight flight = FlightMapper.INSTANCE.flightDTOToFlightEntity(flightDTO);
        return FlightMapper.INSTANCE.flightEntityToFlightDTO(flightRepository.save(flight));
    }

    public void deleteFlight(Long id) {
        flightRepository.deleteById(id);
    }

    public List<FlightDTO> findAll() {
        return flightRepository.findAll().stream()
                .map(FlightMapper.INSTANCE::flightEntityToFlightDTO)
                .toList();
    }
}
