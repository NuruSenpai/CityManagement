package org.example.citymanagement.controller.controllerInterface;

import org.example.citymanagement.DTO.PersonDTO;
import org.example.citymanagement.entity.Person;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

public interface RelationshipController {

    @PostMapping("/{personId}/cars/{carId}")
    public Person addCarToPerson(@PathVariable Long personId, @PathVariable Long carId);

    @PostMapping("/{personId}/homes/{homeId}")
    public PersonDTO addHomeToPerson(@PathVariable Long personId, @PathVariable Long homeId);
}
