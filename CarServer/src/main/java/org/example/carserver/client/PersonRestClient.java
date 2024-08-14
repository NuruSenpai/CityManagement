package org.example.carserver.client;

import lombok.RequiredArgsConstructor;
import org.example.api.DTO.PersonDTO;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Profile("rest")
@RequiredArgsConstructor
@Component
public class PersonRestClient implements PersonClient {
    private final RestTemplate restTemplate;

    @Override
    public List<org.example.api.DTO.PersonDTO> getAllPerson() {
        return List.of();
    }

    @Override
    public org.example.api.DTO.PersonDTO createPerson(org.example.api.DTO.PersonDTO personDTO) {
        return null;
    }

    public PersonDTO getPersonById(Long id) {
        String url = "http://CityManagement/persons/get/" + id;
        return restTemplate.getForObject(url, PersonDTO.class);
    }

    @Override
    public void deletePersonById(Long id) {

    }

    @Override
    public org.example.api.DTO.PersonDTO updatePerson(Long id, org.example.api.DTO.PersonDTO personDTO) {
        return null;
    }

    @Override
    public List<org.example.api.DTO.PersonDTO> getPassportData(char letter) {
        return List.of();
    }

    @Override
    public List<org.example.api.DTO.PersonDTO> getPersonsByStreet(String street) {
        return List.of();
    }
}
