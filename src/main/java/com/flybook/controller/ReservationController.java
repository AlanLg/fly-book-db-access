package com.flybook.controller;

import com.flybook.model.dto.FlightAndDepartureDateDTO;
import com.flybook.model.dto.ProfileDTO;
import com.flybook.model.dto.ReservationDTO;
import com.flybook.service.ReservationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/db-access/reservation")
public class ReservationController {

    private final ReservationService reservationService;

    @PostMapping("/save")
    public ResponseEntity<ReservationDTO> saveReservation(@RequestBody ReservationDTO reservationDTO) {
        log.info("Request to save profile: {}", reservationDTO);
        return ResponseEntity.ok(reservationService.saveReservation(reservationDTO));
    }

    @GetMapping("/flight/{flightId}/client/{clientId}")
    public ResponseEntity<ReservationDTO> findByFlightIdAndClientId(@PathVariable Long clientId, @PathVariable Long flightId) {
        log.info("Request to find reservation by flight id: {} and client id: {}", flightId, clientId);
        return ResponseEntity.ok(reservationService.findByFlightIdAndClientId(flightId, clientId));
    }

    @PostMapping("/count")
    public ResponseEntity<Integer> countDistinctByFlightAndDepartureDate(@RequestBody FlightAndDepartureDateDTO flightAndDepartureDateDTO) {
        log.info("Request to count distinct reservations by flightAndDepartureDateDTO : {}", flightAndDepartureDateDTO);
        return ResponseEntity.ok(reservationService.countDistinctByFlightAndDepartureDate(flightAndDepartureDateDTO));
    }

}
