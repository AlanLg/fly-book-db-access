package com.flybook.mapper;

import com.flybook.model.dto.response.AirplaneDTOResponse;
import com.flybook.model.entity.Airplane;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AirplaneMapper {
    AirplaneMapper INSTANCE = Mappers.getMapper(AirplaneMapper.class);

    AirplaneDTOResponse airplaneEntityToAirplaneDTOResponse(Airplane airplane);
}
