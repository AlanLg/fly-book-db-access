package com.flybook.mapper;

import com.flybook.model.dto.AirplaneDTO;
import com.flybook.model.entity.Airplane;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AirplaneMapper {
    AirplaneMapper INSTANCE = Mappers.getMapper(AirplaneMapper.class);

    AirplaneDTO airplaneEntityToAirplaneDTO(Airplane airplane);
    Airplane airplaneDTOToAirplaneEntity(AirplaneDTO airplaneDTO);
}
