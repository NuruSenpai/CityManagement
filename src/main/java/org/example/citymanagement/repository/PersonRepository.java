package org.example.citymanagement.repository;

import org.example.citymanagement.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PersonRepository extends JpaRepository<Person, Long> {


    @Query(value = "select * FROM person p WHERE p.sex_type = 'MALE' AND p.surname ilike :letter%", nativeQuery = true)
    List<Person> findPassportDataBySurnameStartingWith(@Param("letter") String letter);
}
