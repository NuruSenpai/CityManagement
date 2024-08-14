package org.example.citymanagement.service.serviceInterface;

import org.example.citymanagement.entity.Person;

import java.util.List;

public interface PersonService {
    List<Person> getAllPersons();

    Person createPerson(Person person);

    Person addHomeToPerson(Long personId, Long HomeId);

    Person findPersonById(Long id);

    void deletePersonById(Long id);

    Person updatePersonById(Long id, Person person);

    List<Person> findPersonsByStreet(String street);

    List<Person> findPassportDataByLastName(char letter);
}
