package org.example.carserver.client;

import org.example.carserver.carDTO.PersonDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface PersonController {
    @GetMapping
    List<PersonDTO> getAllPerson();

    @PostMapping("/create")
    PersonDTO createPerson(@RequestBody PersonDTO personDTO);

    @GetMapping("persons/get/{id}")
    PersonDTO getPersonById(@PathVariable Long id);

    @DeleteMapping("/delete/{id}")
    void deletePersonById(@PathVariable Long id);

    @PutMapping("/update/{id}")
    PersonDTO updatePerson(@PathVariable Long id, @RequestBody PersonDTO personDTO);

    @GetMapping("/passport-data")
    List<PersonDTO> getPassportData(@RequestParam char letter);

    @GetMapping("/person-by-street")
    List<PersonDTO> getPersonsByStreet(@RequestParam String street);
}
