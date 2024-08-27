package org.example.carserver.service;

import lombok.RequiredArgsConstructor;
import org.example.api.DTO.PersonDTO;
import org.example.carserver.carrepository.CarRepository;
import org.example.carserver.client.PersonClient;
import org.example.carserver.service.carserviceinterface.CarService;
import org.example.carserver.entity.Car;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CarServiceImpl implements CarService {
    private final CarRepository carRepository;
    private final PersonClient personClient;

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
        carToUpdate.setModel(car.getModel());
        carToUpdate.setColor(car.getColor());

        return carRepository.save(carToUpdate);
    }

    public List<Car> findCarsByPersonId(Long personId) {
        return carRepository.findAllByPersonID(personId);
    }

    public Car addPersonToCar(Long personId, Long carId) {
        PersonDTO personDTO =  personClient.getPersonById(personId);
        if (personDTO == null) {
            throw new RuntimeException("Person not found");
        }
        Car car = carRepository.findById(carId).orElseThrow();
        car.setPersonID(personId);
        return carRepository.save(car);
    }

    public void deleteAllOfPersonCars(Long personId) {
        carRepository.deleteAllByPersonID(personId);
    }


}
