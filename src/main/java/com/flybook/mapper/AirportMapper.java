package com.flybook.mapper;

import com.flybook.model.dto.response.AirportDTOResponse;
import com.flybook.model.entity.Airport;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface AirportMapper {
    AirportMapper INSTANCE = Mappers.getMapper(AirportMapper.class);

    AirportDTOResponse airportEntityToAirportDTOResponse(Airport airport);

    List<AirportDTOResponse> airportEntitiesToAirportDTOResponses(List<Airport> airports);
}
