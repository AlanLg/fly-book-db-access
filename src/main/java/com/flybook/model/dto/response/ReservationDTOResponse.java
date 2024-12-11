package com.flybook.model.dto.response;


import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class ReservationDTOResponse {
    private Long id;
    private FlightDTOResponse flightDTOResponse;
    private ClientDTOResponse clientDTOResponse;
    private List<ProfileDTOResponse> profileDTOResponses;
    private LocalDate departureDate;
    private int nbLuggage;
    private double priceOfReservation;
    private LocalDateTime creationDate = LocalDateTime.now();
}