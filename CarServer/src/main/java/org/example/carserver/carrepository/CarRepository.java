package org.example.carserver.carrepository;

import org.example.carserver.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, Long> {
    List<Car> findAllByPersonID(@Param("personId") Long personId);
}
