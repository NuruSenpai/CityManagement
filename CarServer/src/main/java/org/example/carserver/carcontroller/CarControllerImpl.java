package org.example.carserver.carcontroller;

import lombok.RequiredArgsConstructor;
import org.example.carserver.carDTO.CarDTO;
import org.example.carserver.carcontroller.carcontrollerinterface.CarController;
import org.example.carserver.service.CarServiceImpl;
import org.example.carserver.entity.Car;
import org.example.carserver.mapper.CarMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/cars")
public class CarControllerImpl implements CarController {
    private final CarServiceImpl carService;


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

    @GetMapping("/persons/{personId}")
    public List<CarDTO> getAllCarsByPersonId(@PathVariable Long personId) {
        return CarMapper.INSTANCE.carListToCarDTOList(carService.findCarsByPersonId(personId));
    }

    @PostMapping("/{personId}/cars/{carId}")
    public CarDTO addCarToPerson(@PathVariable Long personId, @PathVariable Long carId) {
        return CarMapper.INSTANCE.carToCarDTO(carService.addPersonToCar(personId, carId));
    }

}
