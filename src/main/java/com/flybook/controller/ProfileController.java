package com.flybook.controller;

import com.flybook.model.dto.ClientDTO;
import com.flybook.model.dto.ProfileDTO;
import com.flybook.service.ClientService;
import com.flybook.service.ProfileService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/db-access/profile")
public class ProfileController {

    private final ProfileService profileService;

    @PostMapping("")
    public ResponseEntity<ProfileDTO> saveProfile(@RequestBody ProfileDTO profileDTO) {
        log.info("Request to save profile: {}", profileDTO);
        return ResponseEntity.ok(profileService.saveProfile(profileDTO));
    }
}
