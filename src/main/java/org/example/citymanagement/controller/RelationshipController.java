package org.example.citymanagement.controller;


import lombok.RequiredArgsConstructor;
import org.example.citymanagement.DTO.PersonDTO;
import org.example.citymanagement.entity.Person;
import org.example.citymanagement.mapper.PersonMapper;
import org.example.citymanagement.service.PersonService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/RS")
public class RelationshipController {
    private final PersonService personService;

    @PostMapping("/{personId}/cars/{carId}")
    public Person addCarToPerson(@PathVariable Long personId, @PathVariable Long carId) {
        return personService.addCarToPerson(personId, carId);
    }

    @PostMapping("/{personId}/homes/{homeId}")
    public PersonDTO addHomeToPerson(@PathVariable Long personId, @PathVariable Long homeId) {
        return PersonMapper.INSTANCE.personToPersonDTO(personService.addHomeToPerson(personId, homeId));
    }
}
