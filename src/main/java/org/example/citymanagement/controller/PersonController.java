package org.example.citymanagement.controller;

import lombok.RequiredArgsConstructor;
import org.example.citymanagement.DTO.PersonDTO;
import org.example.citymanagement.entity.Person;
import org.example.citymanagement.mapper.PersonMapper;
import org.example.citymanagement.service.PersonService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/persons")
public class PersonController implements org.example.citymanagement.controller.controllerInterface.PersonController {
    private final PersonService personService;

    @GetMapping
    public List<PersonDTO> getAllPerson() {
        return personService.getAllPersons().stream()
                .map(PersonMapper.INSTANCE::personToPersonDTO)
                .collect(Collectors.toList());
    }

    @PostMapping("/create")
    public PersonDTO createPerson(@RequestBody PersonDTO personDTO) {
        Person person = PersonMapper.INSTANCE.personDTOToPerson(personDTO);
        return PersonMapper.INSTANCE.personToPersonDTO(personService.createPerson(person));

    }


    @GetMapping("/get/{id}")
    public Person getPersonById(@PathVariable Long id) {
        return personService.findPersonById(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deletePersonById(@PathVariable Long id) {
        personService.deletePersonById(id);
    }

    @PutMapping("/update/{id}")
    public Person updatePerson(@PathVariable Long id, @RequestBody Person person) {
        return personService.updatePersonById(id, person);
    }

    @GetMapping("/passport-data")
    public List<String> getPassportData(@RequestParam char letter) {
        return personService.findPassportDataByLastName(letter);
    }

}
