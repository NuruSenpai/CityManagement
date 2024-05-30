package org.example.citymanagement.controller;

import lombok.RequiredArgsConstructor;
import org.example.citymanagement.entity.Car;
import org.example.citymanagement.service.CarService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/cars")
public class CarController {
    private final CarService carService;

    @PostMapping("/create")
    public Car createCar(@RequestBody Car car) {
        return carService.saveCar(car);
    }

    @GetMapping("/get/{id}")
    public Car getCarById(@PathVariable Long id) {
        return carService.findCarById(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteCarById(@PathVariable Long id) {
        carService.deleteCarById(id);
    }

    @PutMapping("/update/{id}")
    public Car updateCar(@PathVariable Long id, @RequestBody Car car) {
        return carService.updateCarById(id, car);
    }
}
