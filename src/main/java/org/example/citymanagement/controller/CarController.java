package org.example.citymanagement.controller;

import lombok.RequiredArgsConstructor;
import org.example.citymanagement.DTO.CarDTO;
import org.example.citymanagement.aspect.EnableLogger;
import org.example.citymanagement.entity.Car;
import org.example.citymanagement.mapper.CarMapper;
import org.example.citymanagement.service.CarService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/cars")
public class CarController implements org.example.citymanagement.controller.controllerInterface.CarController {
    private final CarService carService;

    @PostMapping("/create")
    public CarDTO createCar(@RequestBody CarDTO carDTO) {
        Car car = CarMapper.INSTANCE.carDTOToCar(carDTO);
        return CarMapper.INSTANCE.carToCarDTO(carService.createCar(car));
    }

    @GetMapping("/get/{id}")
    public CarDTO getCarById(@PathVariable Long id) {
        return CarMapper.INSTANCE.carToCarDTO(carService.findCarById(id));
    }

    @DeleteMapping("/delete/{id}")
    public void deleteCarById(@PathVariable Long id) {
        carService.deleteCarById(id);
    }

    @PutMapping("/update/{id}")
    public CarDTO updateCar(@PathVariable Long id, @RequestBody CarDTO carDTO) {
        Car car = CarMapper.INSTANCE.carDTOToCar(carDTO);
        return CarMapper.INSTANCE.carToCarDTO(carService.updateCarById(id, car));
    }

    @EnableLogger(classType = "Long")
    @GetMapping("/persons/{personId}")
    public List<CarDTO> getAllCarsByPersonId(@PathVariable Long personId) {
        return CarMapper.INSTANCE.carListToCarDTOList(carService.findCarsByPersonId(personId));
    }

}
