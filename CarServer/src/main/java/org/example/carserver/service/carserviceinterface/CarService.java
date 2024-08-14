package org.example.carserver.service.carserviceinterface;


import org.example.carserver.entity.Car;

import java.util.List;

public interface CarService {

    Car createCar(Car car);

    Car findCarById(Long id);

    void deleteCarById(Long id);

    Car updateCarById(Long id, Car car);

    List<Car> findCarsByPersonId(Long personId);
}
