package org.example.citymanagement.controller;

import lombok.RequiredArgsConstructor;
import org.example.citymanagement.entity.Person;
import org.example.citymanagement.service.PersonService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class PersonController {
    private final PersonService personService;

    @PostMapping("/create")
    public Person createPerson(@RequestBody Person person) {
        return personService.createPerson(person);
    }
    @GetMapping("/get/{id}")
    public Person getPersonById(@PathVariable Long id) {
        return personService.findPersonById(id);
    }
}
