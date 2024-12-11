package com.flybook.mapper;

import com.flybook.model.dto.ClientDTO;
import com.flybook.model.entity.Client;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ClientMapper {
    ClientMapper INSTANCE = Mappers.getMapper(ClientMapper.class);

    ClientDTO clientEntityToClientDTOResponse(Client client);
    Client clientDTOToClientEntity(ClientDTO clientDTO);

}
