package com.flybook.controller;

import com.flybook.model.dto.FlightAndDepartureDateDTO;
import com.flybook.model.dto.ReservationDTO;
import com.flybook.service.ReservationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/db-access/reservation")
public class ReservationController {

    private final ReservationService reservationService;

    @PostMapping("")
    public ResponseEntity<ReservationDTO> saveReservation(@RequestBody ReservationDTO reservationDTO) {
        log.info("Request to save profile: {}", reservationDTO);
        return ResponseEntity.ok(reservationService.saveReservation(reservationDTO));
    }

    @GetMapping("/client-email/{clientEmail}")
    public ResponseEntity<List<ReservationDTO>> findByClientEmail(@PathVariable String clientEmail) {
        log.info("Request to find reservation by client Email: {}", clientEmail);
        return ResponseEntity.ok(reservationService.findByClientEmail(clientEmail));
    }

    @GetMapping("/flight/{flightId}/client/{clientId}")
    public ResponseEntity<ReservationDTO> findByFlightIdAndClientId(@PathVariable Long clientId, @PathVariable Long flightId) {
        log.info("Request to find reservation by flight id: {} and client id: {}", flightId, clientId);
        return ResponseEntity.ok(reservationService.findByFlightIdAndClientId(flightId, clientId));
    }

    @GetMapping("/flight/{flightId}")
    public ResponseEntity<List<ReservationDTO>> findByFlightId(@PathVariable Long flightId) {
        log.info("Request to find reservation by flight id: {}", flightId);
        return ResponseEntity.ok(reservationService.findByFlightId(flightId));
    }

    @PostMapping("/count")
    public ResponseEntity<Integer> countDistinctByFlightAndDepartureDate(@RequestBody FlightAndDepartureDateDTO flightAndDepartureDateDTO) {
        log.info("Request to count distinct reservations by flightAndDepartureDateDTO : {}", flightAndDepartureDateDTO);
        return ResponseEntity.ok(reservationService.countDistinctByFlightAndDepartureDate(flightAndDepartureDateDTO));
    }

}
