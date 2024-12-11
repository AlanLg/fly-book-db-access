package com.flybook.mapper;

import com.flybook.model.dto.response.FlightDTOResponse;
import com.flybook.model.entity.Flight;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface FlightMapper {
    FlightMapper INSTANCE = Mappers.getMapper(FlightMapper.class);

    FlightDTOResponse flightEntityToFlightDTOResponse(Flight flight);

    List<FlightDTOResponse> flightEntitiesToFlightDTOResponses(List<Flight> flights);

}
