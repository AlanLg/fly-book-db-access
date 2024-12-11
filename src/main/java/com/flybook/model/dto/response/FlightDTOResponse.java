package com.flybook.model.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FlightDTOResponse {
    private Long flightId;
    private AirportDTOResponse departureAirportDTOResponse;
    private AirportDTOResponse arrivalAirportDTOResponse;
    private double price;
    private AirplaneDTOResponse airplaneDTOResponse;
    private int numberOfSeats;
}