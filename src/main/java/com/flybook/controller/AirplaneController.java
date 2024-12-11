package com.flybook.controller;

import com.flybook.model.dto.AirplaneDTO;
import com.flybook.service.AirplaneService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/db-access/airplane")
public class AirplaneController {

    private final AirplaneService airplaneService;

    @GetMapping("/id/{id}")
    public ResponseEntity<AirplaneDTO> findById(@PathVariable Long id) {
        log.info("Request to find airplane by id: {}", id);
        return ResponseEntity.ok(airplaneService.findById(id));
    }

    @GetMapping("/brand/{brand}/model/{model}")
    public ResponseEntity<AirplaneDTO> findByBrandAndModel(@PathVariable String brand, @PathVariable String model) {
        log.info("Request to find airplane by brand : {} and model: {}", brand, model);
        return ResponseEntity.ok(airplaneService.findByBrandAndModel(brand, model));
    }

    @PostMapping("/")
    public ResponseEntity<AirplaneDTO> saveAirplane(@RequestBody AirplaneDTO airplaneDTO) {
        log.info("Request to save airplane: {}", airplaneDTO);
        return ResponseEntity.ok(airplaneService.saveAirplane(airplaneDTO));
    }

    @DeleteMapping("/id/{id}")
    public ResponseEntity<AirplaneDTO> deleteAirplane(@PathVariable Long id) {
        log.info("Request to delete airplane by id: {}", id);
        airplaneService.deleteAirplane(id);
        return ResponseEntity.ok().build();
    }
}
