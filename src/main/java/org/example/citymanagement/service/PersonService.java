package org.example.citymanagement.service;

import lombok.RequiredArgsConstructor;
import org.example.citymanagement.entity.Person;
import org.example.citymanagement.repository.PersonRepository;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class PersonService {
    private final PersonRepository personRepository;


    public Person createPerson(Person person) {
        return personRepository.save(person);
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
