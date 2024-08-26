package org.example.citymanagement.service;

import lombok.RequiredArgsConstructor;

import org.example.citymanagement.entity.Home;
import org.example.citymanagement.entity.Person;
import org.example.citymanagement.exception.PersonNotFoundException;
import org.example.citymanagement.repository.PersonRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PersonService implements org.example.citymanagement.service.serviceInterface.PersonService {
    private final PersonRepository personRepository;
    private final HomeService homeService;
    private final KafkaSenderService kafkaSenderService;

    public List<Person> getAllPersons() {
        return personRepository.findAll();
    }

    public Person createPerson(Person person) {
       return personRepository.save(person);
    }

    @Transactional()
    public Person addHomeToPerson(Long personId, Long HomeId) {
        Person person = findPersonById(personId);
        Home home = homeService.findHomeById(HomeId);
        home.getPersons().add(person);
        person.getHomes().add(home);
        return personRepository.save(person);
    }

    public Person findPersonById(Long id) {
        return personRepository.findById(id).orElseThrow(()-> new PersonNotFoundException(id));
    }

    public void deletePersonById(Long id) {
        personRepository.deleteById(id);
        kafkaSenderService.send("person-deleted", String.valueOf(id));
    }

    public Person updatePersonById(Long id, Person person) {
        Person personToUpdate = findPersonById(id);
        personToUpdate.setName(person.getName());

        return personRepository.save(personToUpdate);
    }

    public List<Person> findPersonsByStreet(String street) {
       return homeService.findAllHomeByStreet(street).stream()
                .flatMap(home -> home.getPersons().stream())
                .collect(Collectors.toList());
    }

    public List<Person> findPassportDataByLastName(char letter){
        return personRepository.findPassportDataBySurnameStartingWith(letter + "%");

    }
}
