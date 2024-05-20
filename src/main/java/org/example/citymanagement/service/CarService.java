package org.example.citymanagement.service;

import lombok.RequiredArgsConstructor;
import org.example.citymanagement.entity.Car;
import org.example.citymanagement.repository.CarRepository;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CarService {
    private final CarRepository carRepository;

    public Car createCar(Car car) {
        return carRepository.save(car);
    }

    public Car findCarById(Long id) {
        return carRepository.findById(id).orElseThrow();
    }

    public void deleteCarById(Long id) {
        carRepository.deleteById(id);
    }

    public Car updateCarById(Long id, Car car) {
        Car carToUpdate = carRepository.findById(id).orElseThrow();
        carToUpdate.setBrand(car.getBrand());

        return carRepository.save(carToUpdate);
    }
}
