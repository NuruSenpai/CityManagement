package org.example.citymanagement.controller.controllerInterface;

import org.example.citymanagement.DTO.CarDTO;
import org.example.citymanagement.entity.Car;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface CarController {
    @PostMapping("/create")
    CarDTO createCar(@RequestBody CarDTO carDTO);

    @GetMapping("/get/{id}")
    Car getCarById(@PathVariable Long id);

    @DeleteMapping("/delete/{id}")
    void deleteCarById(@PathVariable Long id);

    @PutMapping("/update/{id}")
    Car updateCar(@PathVariable Long id, @RequestBody Car car);

    @GetMapping("/persons/{personId}")
    List<Car> getAllCarsByPersonId(@PathVariable Long personId);
}
