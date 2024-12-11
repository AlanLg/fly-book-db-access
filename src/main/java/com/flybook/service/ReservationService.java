package com.flybook.service;

import com.flybook.mapper.AirplaneMapper;
import com.flybook.mapper.FlightMapper;
import com.flybook.mapper.ReservationMapper;
import com.flybook.model.dto.AirplaneDTO;
import com.flybook.model.dto.FlightAndDepartureDateDTO;
import com.flybook.model.dto.ReservationDTO;
import com.flybook.model.entity.Airplane;
import com.flybook.model.entity.Reservation;
import com.flybook.repository.AirplaneRepository;
import com.flybook.repository.ReservationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReservationService {

    private final ReservationRepository reservationRepository;

    public ReservationDTO saveReservation(ReservationDTO reservationDTO) {
        Reservation reservation = ReservationMapper.INSTANCE.reservationDTOToReservationEntity(reservationDTO);
        return ReservationMapper.INSTANCE.reservationEntityToReservationDTO(reservationRepository.save(reservation));
    }

    public ReservationDTO findByFlightIdAndClientId(Long flightId, Long clientId) {
        return reservationRepository.findByFlight_FlightIdAndClient_Id(flightId, clientId)
                .map(ReservationMapper.INSTANCE::reservationEntityToReservationDTO)
                .orElse(null);
    }

    public Integer countDistinctByFlightAndDepartureDate(FlightAndDepartureDateDTO flightAndDepartureDateDTO) {
        return reservationRepository.countDistinctByFlightAndDepartureDate(FlightMapper.INSTANCE.flightDTOToFlightEntity(flightAndDepartureDateDTO.getFlightDTO()), flightAndDepartureDateDTO.getDepartureDate());
    }
}
