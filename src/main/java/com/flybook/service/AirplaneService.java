package com.flybook.service;

import com.flybook.mapper.AirplaneMapper;
import com.flybook.model.dto.AirplaneDTO;
import com.flybook.model.entity.Airplane;
import com.flybook.repository.AirplaneRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AirplaneService {

    private final AirplaneRepository airplaneRepository;

    public AirplaneDTO findById(Long id) {
        return airplaneRepository.findById(id)
                .map(AirplaneMapper.INSTANCE::airplaneEntityToAirplaneDTO)
                .orElse(null);
    }
    public AirplaneDTO findByBrandAndModel(String brand, String model) {
        return airplaneRepository.findByBrandAndModel(brand, model)
                .map(AirplaneMapper.INSTANCE::airplaneEntityToAirplaneDTO)
                .orElse(null);
    }


    public AirplaneDTO saveAirplane(AirplaneDTO airplaneDTO) {
        Airplane airplane = AirplaneMapper.INSTANCE.airplaneDTOToAirplaneEntity(airplaneDTO);
        return AirplaneMapper.INSTANCE.airplaneEntityToAirplaneDTO(airplaneRepository.save(airplane));
    }

    public void deleteAirplane(Long id) {
        airplaneRepository.deleteById(id);
    }
}
