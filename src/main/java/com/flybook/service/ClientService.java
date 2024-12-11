package com.flybook.service;

import com.flybook.mapper.ClientMapper;
import com.flybook.model.dto.ClientDTO;
import com.flybook.model.entity.Client;
import com.flybook.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClientService {
    private final ClientRepository clientRepository;

    public ClientDTO findByEmail(String email) {
        return clientRepository.findByEmail(email)
                .map(ClientMapper.INSTANCE::clientEntityToClientDTOResponse)
                .orElse(null);
    }

    public ClientDTO findById(Long id) {
        return clientRepository.findById(id)
                .map(ClientMapper.INSTANCE::clientEntityToClientDTOResponse)
                .orElse(null);
    }

    public ClientDTO saveClient(ClientDTO clientDTO) {
        Client client = ClientMapper.INSTANCE.clientDTOToClientEntity(clientDTO);
        return ClientMapper.INSTANCE.clientEntityToClientDTOResponse(clientRepository.save(client));
    }

    public void deleteClient(Long id) {
        clientRepository.deleteById(id);
    }
}
