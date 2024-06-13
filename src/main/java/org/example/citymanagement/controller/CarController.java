package org.example.citymanagement.controller;

import lombok.RequiredArgsConstructor;
import org.example.citymanagement.DTO.CarDTO;
import org.example.citymanagement.entity.Car;
import org.example.citymanagement.mapper.CarMapper;
import org.example.citymanagement.service.CarService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/cars")
public class CarController {
    private final CarService carService;

    @PostMapping("/create")
    public CarDTO createCar(@RequestBody CarDTO carDTO) {
        Car car = CarMapper.INSTANCE.carDTOToCar(carDTO);
        return CarMapper.INSTANCE.carToCarDTO(carService.createCar(car));
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

    @GetMapping("/persons/{personId}")
    public List<Car> getAllCarsByPersonId(@PathVariable Long personId) {
        return carService.findCarsByPersonId(personId);
    }

}
