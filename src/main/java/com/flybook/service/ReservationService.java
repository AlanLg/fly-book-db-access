package com.flybook.service;

import com.flybook.mapper.FlightMapper;
import com.flybook.mapper.ReservationMapper;
import com.flybook.model.dto.FlightAndDepartureDateDTO;
import com.flybook.model.dto.ReservationDTO;
import com.flybook.model.entity.Reservation;
import com.flybook.repository.ReservationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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
        return reservationRepository.countDistinctByFlightAndDepartureDate(FlightMapper.INSTANCE.flightDTOToFlightEntity(flightAndDepartureDateDTO.getFlight()), flightAndDepartureDateDTO.getDepartureDate());
    }

    public List<ReservationDTO> findByClientEmail(String clientEmail) {
        return reservationRepository.findByClient_Email(clientEmail)
                .stream()
                .map(ReservationMapper.INSTANCE::reservationEntityToReservationDTO)
                .toList();
    }

    public List<ReservationDTO> findByFlightId(Long flightId) {
        return reservationRepository.findByFlight_FlightId(flightId)
                .stream()
                .map(ReservationMapper.INSTANCE::reservationEntityToReservationDTO)
                .toList();
    }
}
