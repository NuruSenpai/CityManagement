package org.example.citymanagement.controller.controllerInterface;

import org.example.citymanagement.DTO.PersonDTO;
import org.example.citymanagement.entity.Person;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface PersonController {
    @GetMapping
    public List<PersonDTO> getAllPerson();

    @PostMapping("/create")
    public PersonDTO createPerson(@RequestBody PersonDTO personDTO);

    @GetMapping("/get/{id}")
    public PersonDTO getPersonById(@PathVariable Long id);

    @DeleteMapping("/delete/{id}")
    public void deletePersonById(@PathVariable Long id);

    @PutMapping("/update/{id}")
    public PersonDTO updatePerson(@PathVariable Long id, @RequestBody PersonDTO personDTO);

    @GetMapping("/passport-data")
    public List<PersonDTO> getPassportData(@RequestParam char letter);

    @GetMapping("/person-by-street")
    public List<PersonDTO> getPersonsByStreet(@RequestParam String street);
}
