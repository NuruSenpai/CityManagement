package org.example.carserver.client;

import lombok.RequiredArgsConstructor;
import org.example.carserver.carDTO.PersonDTO;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@RequiredArgsConstructor
@Component
public class PersonClient {
    private final RestTemplate restTemplate;

    public PersonDTO getPersonById(Long id) {
        String url = "http://CityManagement/persons/get/" + id;
        return restTemplate.getForObject(url, PersonDTO.class);
    }
}
