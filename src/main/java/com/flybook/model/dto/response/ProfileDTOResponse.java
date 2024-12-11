package com.flybook.model.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class ProfileDTOResponse {
    private Long id;
    private String firstname;
    private String lastname;
    private LocalDate birthday;
    private ReservationDTOResponse reservationDTOResponse;
    private int nbLuggage;
}
