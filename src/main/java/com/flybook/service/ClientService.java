package com.flybook.service;

import com.flybook.mapper.ClientMapper;
import com.flybook.model.dto.ClientDTO;
import com.flybook.model.entity.Client;
import com.flybook.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
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

        log.info("Save client {}", client);

        Client save = clientRepository.save(client);

        log.info("Saveed client {}", save);
        return ClientMapper.INSTANCE.clientEntityToClientDTOResponse(save);
    }

    public void deleteClient(Long id) {
        clientRepository.deleteById(id);
    }
}
