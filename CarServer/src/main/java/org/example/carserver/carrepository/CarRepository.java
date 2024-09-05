package org.example.carserver.carrepository;

import org.example.carserver.entity.Car;
import org.example.carserver.enums.CarStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, Long> {
    List<Car> findAllByPersonID(@Param("personId") Long personId);
    void deleteCarsByPersonID(Long personId);

    @Modifying
    @Query("UPDATE Car c SET c.status = :status WHERE c.personID =:personId")
    void updateCarStatusByPersonId(@Param("personId") Long personId, @Param("status") CarStatus status);
}
