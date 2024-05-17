package org.example.citymanagement.repository;

import org.example.citymanagement.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
