package org.example.citymanagement.repository;

import org.example.citymanagement.entity.Home;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface HomeRepository extends JpaRepository<Home, Long> {

    @Query(value = "select Home from Home h WHERE h.address ILIKE :street")
    List<Home> findAllByStreet(@Param("street") String street);
}
