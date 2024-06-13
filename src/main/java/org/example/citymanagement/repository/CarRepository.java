package org.example.citymanagement.repository;

import org.example.citymanagement.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, Long> {
    List<Car> findAllByPersonId(@Param("personId") Long personId);
}
