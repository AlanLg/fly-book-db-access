package com.flybook.controller;

import com.flybook.model.dto.ClientDTO;
import com.flybook.model.dto.FlightDTO;
import com.flybook.service.ClientService;
import com.flybook.service.FlightService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/db-access/flight")
public class FlightController {

    private final FlightService flightService;

    @GetMapping("/id/{id}")
    public ResponseEntity<FlightDTO> findById(@PathVariable Long id) {
        log.info("Request to find flight by id: {}", id);
        return ResponseEntity.ok(flightService.findById(id));
    }

    @GetMapping("/all")
    public ResponseEntity<List<FlightDTO>> findAll() {
        log.info("Request to find all flights");
        return ResponseEntity.ok(flightService.findAll());
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity<Void> deleteFlight(@PathVariable Long id) {
        log.info("Request to delete flight by id: {}", id);
        flightService.deleteFlight(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/save")
    public ResponseEntity<FlightDTO> saveFlight(@RequestBody FlightDTO flightDTO) {
        log.info("Request to save flight: {}", flightDTO);
        return ResponseEntity.ok(flightService.saveFlight(flightDTO));
    }

    @GetMapping("/departure/{departureAirport}/arrival/{arrivalAirport}")
    public ResponseEntity<FlightDTO> findByDepartureAirport(@PathVariable String departureAirport, @PathVariable String arrivalAirport) {
        log.info("Request to find flight by departure airport: {}", departureAirport);
        return ResponseEntity.ok(flightService.findByDepartureAirportAndArrivalAirport(departureAirport, arrivalAirport));
    }
}
