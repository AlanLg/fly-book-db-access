package com.flybook.mapper;

import com.flybook.model.dto.response.ClientDTOResponse;
import com.flybook.model.entity.Client;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ClientMapper {
    ClientMapper INSTANCE = Mappers.getMapper(ClientMapper.class);

    ClientDTOResponse clientEntityToClientDTOResponse(Client client);
}
