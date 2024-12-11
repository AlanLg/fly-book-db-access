package com.flybook.controller;

import com.flybook.model.dto.AirplaneDTO;
import com.flybook.model.dto.AirportDTO;
import com.flybook.service.AirportService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/db-access/airport")
public class AirportController {

    private final AirportService airportService;

    @GetMapping("/id/{id}")
    public ResponseEntity<AirportDTO> findById(@PathVariable Long id) {
        log.info("Request to find airport by id: {}", id);
        return ResponseEntity.ok(airportService.findById(id));
    }

    @GetMapping("/")
    public ResponseEntity<List<AirportDTO>> findAll() {
        log.info("Request to find all airports");
        return ResponseEntity.ok(airportService.findAll());
    }

    @GetMapping("/name/{airportName}")
    public ResponseEntity<AirportDTO> findByAirportName(@PathVariable String airportName) {
        log.info("Request to find airport by name: {}", airportName);
        return ResponseEntity.ok(airportService.findByAirportName(airportName));
    }

    @DeleteMapping("/id/{id}")
    public ResponseEntity<Void> deleteAirport(@PathVariable Long id) {
        log.info("Request to delete airport by id: {}", id);
        airportService.deleteAirport(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/")
    public ResponseEntity<AirportDTO> saveAirport(@RequestBody AirportDTO airportDTO) {
        log.info("Request to save airport: {}", airportDTO);
        return ResponseEntity.ok(airportService.saveAirport(airportDTO));
    }
}
