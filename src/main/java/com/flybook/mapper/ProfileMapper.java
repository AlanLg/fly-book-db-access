package com.flybook.mapper;

import com.flybook.model.dto.ProfileDTO;
import com.flybook.model.entity.Profile;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProfileMapper {
    ProfileMapper INSTANCE = Mappers.getMapper(ProfileMapper.class);

    ProfileDTO profileEntityToProfileDTO(Profile profile);
    Profile profileDTOToProfileEntity(ProfileDTO profileDTO);
}
