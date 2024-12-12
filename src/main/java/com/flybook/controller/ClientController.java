package com.flybook.controller;

import com.flybook.model.dto.ClientDTO;
import com.flybook.service.ClientService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/db-access/client")
public class ClientController {

    private final ClientService clientService;

    @GetMapping("/id/{id}")
    public ResponseEntity<ClientDTO> findById(@PathVariable Long id) {
        log.info("Request to find client by id: {}", id);
        return ResponseEntity.ok(clientService.findById(id));
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<ClientDTO> findByEmail(@PathVariable String email) {
        log.info("Request to find client by email: {}", email);
        return ResponseEntity.ok(clientService.findByEmail(email));
    }

    @DeleteMapping("/id/{id}")
    public ResponseEntity<Void> deleteClient(@PathVariable Long id) {
        log.info("Request to delete client by id: {}", id);
        clientService.deleteClient(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("")
    public ResponseEntity<ClientDTO> saveClient(@RequestBody ClientDTO clientDTO) {
        log.info("Request to save client: {}", clientDTO);
        return ResponseEntity.ok(clientService.saveClient(clientDTO));
    }
}
