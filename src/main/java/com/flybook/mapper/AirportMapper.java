package com.flybook.mapper;

import com.flybook.model.dto.AirplaneDTO;
import com.flybook.model.dto.AirportDTO;
import com.flybook.model.entity.Airplane;
import com.flybook.model.entity.Airport;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface AirportMapper {
    AirportMapper INSTANCE = Mappers.getMapper(AirportMapper.class);

    AirportDTO airportEntityToAirportDTO(Airport airport);
    Airport airportDTOToAirportEntity(AirportDTO airportDTO);
}
