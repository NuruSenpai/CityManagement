package org.example.api.controller;

import org.example.api.DTO.CarDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface CarController {
    @PostMapping("/create")
    CarDTO createCar(@RequestBody CarDTO carDTO);

    @GetMapping("/get/{id}")
    CarDTO getCarById(@PathVariable Long id);


    @DeleteMapping("/delete/{id}")
    void deleteCarById(@PathVariable Long id);

    @PutMapping("/update/{id}")
    CarDTO updateCar(@PathVariable Long id, @RequestBody CarDTO carDTO);

    @GetMapping("/persons/{personId}")
    List<CarDTO> getAllCarsByPersonId(@PathVariable Long personId);

}
