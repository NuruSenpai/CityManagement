package org.example.citymanagement.service;

import lombok.RequiredArgsConstructor;

import org.example.citymanagement.entity.Car;
import org.example.citymanagement.entity.Person;
import org.example.citymanagement.exception.PersonNotFoundException;
import org.example.citymanagement.repository.CarRepository;
import org.example.citymanagement.repository.PersonRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class PersonService {
    private final PersonRepository personRepository;
    private final CarService carService;

    public List<Person> getAllPersons() {
        return personRepository.findAll();
    }

    public Person createPerson(Person person) {
       return personRepository.save(person);
    }

    @Transactional()
    public Car addCarToPerson(Long personId, Car car) {
        Person person = personRepository.findById(personId).orElseThrow();
        car.setPerson(person);
        person.getCar().add(car);
        personRepository.save(person);
        return carService.saveCar(car);
    }

    public Person findPersonById(Long id) {
        return personRepository.findById(id).orElseThrow(()-> new PersonNotFoundException(id));
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
