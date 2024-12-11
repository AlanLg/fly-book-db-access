package com.flybook.mapper;

import com.flybook.model.dto.FlightDTO;
import com.flybook.model.entity.Flight;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface FlightMapper {
    FlightMapper INSTANCE = Mappers.getMapper(FlightMapper.class);

    FlightDTO flightEntityToFlightDTO(Flight flight);
    Flight flightDTOToFlightEntity(FlightDTO flight);
}
