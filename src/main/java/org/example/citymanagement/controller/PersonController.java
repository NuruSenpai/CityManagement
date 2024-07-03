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
    public PersonDTO getPersonById(@PathVariable Long id) {
        return PersonMapper.INSTANCE.personToPersonDTO(personService.findPersonById(id));
    }

    @DeleteMapping("/delete/{id}")
    public void deletePersonById(@PathVariable Long id) {
        personService.deletePersonById(id);
    }

    @PutMapping("/update/{id}")
    public PersonDTO updatePerson(@PathVariable Long id, @RequestBody PersonDTO personDTO) {
        Person person = PersonMapper.INSTANCE.personDTOToPerson(personDTO);
        return PersonMapper.INSTANCE.personToPersonDTO(personService.updatePersonById(id, person));
    }

    @GetMapping("/passport-data")
    public List<PersonDTO> getPassportData(@RequestParam char letter) {
        return PersonMapper.INSTANCE.personListToPersonDTOList(personService.findPassportDataByLastName(letter));
    }

    @GetMapping("/person-by-street")
    public List<PersonDTO> getPersonsByStreet(@RequestParam String street) {
        return PersonMapper.INSTANCE.personListToPersonDTOList(personService.findPersonsByStreet(street));
    }
}
