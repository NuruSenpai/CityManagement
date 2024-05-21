package org.example.citymanagement.service;

import lombok.RequiredArgsConstructor;
import org.example.citymanagement.entity.Car;
import org.example.citymanagement.entity.Person;
import org.example.citymanagement.repository.CarRepository;
import org.example.citymanagement.repository.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RequiredArgsConstructor
@Service
public class PersonService {
    private final PersonRepository personRepository;
    private final CarRepository carRepository;


    public Person createPerson(Person person) {
        return personRepository.save(person);
    }

    public Car addCarToPerson(Long personId, Car car) {
        Person person = findPersonById(personId);
        car.setPerson(person);
        return carRepository.save(car);
    }

    public Person findPersonById(Long id) {
        return personRepository.findById(id).orElseThrow();
    }

    public void deletePersonById(Long id) {
        personRepository.deleteById(id);
    }

    public Person updatePersonById(Long id, Person person) {
        Person personToUpdate = personRepository.findById(id).orElseThrow();
        personToUpdate.setName(person.getName());

        return personRepository.save(personToUpdate);
    }
}
