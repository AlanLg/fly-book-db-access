package com.flybook.service;

import com.flybook.exceptions.FlybookException;
import com.flybook.mapper.AirplaneMapper;
import com.flybook.model.dto.response.AirplaneDTOResponse;
import com.flybook.model.entity.Airplane;
import com.flybook.repository.AirplaneRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AirplaneService {

    private final AirplaneRepository airplaneRepository;

    public AirplaneDTOResponse getAirplane(Long id) {
        Optional<Airplane> byId = airplaneRepository.findById(id);

        if (byId.isPresent()) {
            return AirplaneMapper.INSTANCE.airplaneEntityToAirplaneDTOResponse(byId.get());
        }
        throw new FlybookException("no airplane with id " + id + " in db", HttpStatus.NOT_FOUND);
    }
}
