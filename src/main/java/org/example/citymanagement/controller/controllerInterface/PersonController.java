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
    public Person getPersonById(@PathVariable Long id);

    @DeleteMapping("/delete/{id}")
    public void deletePersonById(@PathVariable Long id);

    @PutMapping("/update/{id}")
    public Person updatePerson(@PathVariable Long id, @RequestBody Person person);

    @GetMapping("/passport-data")
    public List<String> getPassportData(@RequestParam char letter);
}
