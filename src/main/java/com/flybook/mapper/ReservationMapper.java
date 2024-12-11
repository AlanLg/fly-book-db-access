package com.flybook.mapper;

import com.flybook.model.dto.response.ReservationDTOResponse;
import com.flybook.model.entity.Reservation;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ReservationMapper {

    ReservationMapper INSTANCE = Mappers.getMapper(ReservationMapper.class);

    ReservationDTOResponse reservationEntityToReservationDTOResponse(Reservation reservation);
    List<ReservationDTOResponse> reservationEntityToReservationDTOResponse(List<Reservation> reservation);
}
