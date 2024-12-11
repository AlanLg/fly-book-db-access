package com.flybook.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
public class FlightAndDepartureDateDTO {
    private FlightDTO flightDTO;
    private LocalDate departureDate;
}
