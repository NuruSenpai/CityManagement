package org.example.citymanagement.controller.controllerInterface;

import org.example.citymanagement.DTO.PersonDTO;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

public interface RelationshipController {


    @PostMapping("/{personId}/homes/{homeId}")
    PersonDTO addHomeToPerson(@PathVariable Long personId, @PathVariable Long homeId);
}
