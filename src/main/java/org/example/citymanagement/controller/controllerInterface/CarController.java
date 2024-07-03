package org.example.citymanagement.controller.controllerInterface;

import org.example.citymanagement.DTO.CarDTO;
import org.example.citymanagement.entity.Car;
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
    public List<CarDTO> getAllCarsByPersonId(@PathVariable Long personId);
}
