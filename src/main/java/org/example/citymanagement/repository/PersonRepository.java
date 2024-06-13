package org.example.citymanagement.repository;

import org.example.citymanagement.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Objects;

public interface PersonRepository extends JpaRepository<Person, Long> {


    @Query(value = "select p.surname, p.passport_data FROM person p WHERE p.sex_type = 'MALE' AND p.surname LIKE :letter%", nativeQuery = true)
    List<String> findPassportDataBySurnameStartingWith(@Param("letter") String letter);
}
