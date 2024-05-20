package org.example.citymanagement.repository;

import org.example.citymanagement.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Long> {
}
