package org.example.citymanagement.service.serviceInterface;

import org.example.citymanagement.entity.Person;

import java.util.List;

public interface PersonService {
    List<Person> getAllPersons();

    Person createPerson(Person person);

    Person addCarToPerson(Long personId, Long CarId);

    Person addHomeToPerson(Long personId, Long HomeId);

    Person findPersonById(Long id);

    void deletePersonById(Long id);

    Person updatePersonById(Long id, Person person);

    List<Person> findPersonsByStreet(String street);

    List<String> findPassportDataByLastName(char letter);
}
