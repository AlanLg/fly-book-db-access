package com.flybook.service;

import com.flybook.mapper.ProfileMapper;
import com.flybook.model.dto.ProfileDTO;
import com.flybook.model.entity.Profile;
import com.flybook.repository.ProfileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProfileService {

    private final ProfileRepository profileRepository;

    public ProfileDTO saveProfile(ProfileDTO profileDTO) {
        Profile profile = ProfileMapper.INSTANCE.profileDTOToProfileEntity(profileDTO);
        return ProfileMapper.INSTANCE.profileEntityToProfileDTO(profileRepository.save(profile));
    }
}
