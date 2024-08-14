package org.example.citymanagement.client;

import lombok.RequiredArgsConstructor;
import org.example.citymanagement.DTO.CarDTO;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;

@RequiredArgsConstructor
@Component
public class CarClient {
    private final RestTemplate restTemplate;

    public List<CarDTO> getCarsByPersonId(Long id) {
        String url = "http://CarServer/cars/persons/" + id;
        CarDTO[] cars = restTemplate.getForObject(url, CarDTO[].class);

        if (cars == null) {
            return Collections.emptyList();
        }

        return List.of(cars);
    }
}
