/*
package org.example.citymanagement;


import jakarta.inject.Inject;
import org.example.citymanagement.entity.Person;
import org.example.citymanagement.exception.PersonNotFoundException;
import org.example.citymanagement.repository.PersonRepository;
import org.example.citymanagement.service.PersonService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Optional;

public class PersonServiceTest {

    @InjectMocks
    private PersonService personService;

    @Mock
    private PersonRepository personRepository;

    @BeforeEach
    void setup(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testFindPersonById(){
        Long id = 1L;
        Person person = new Person();
        person.setId(id);
        person.setName("Mark");

        when(personRepository.findById(id)).thenReturn(Optional.of(person));
        Person personFound = personService.findPersonById(id);

        assertNotNull(personFound);
        assertEquals("Mark", personFound.getName());
        verify(personRepository, times(1)).findById(id);
    }

    @Test
    public void testFindPersonByIdNotFound(){
        Long id = 1L;

        when(personRepository.findById(id)).thenReturn(Optional.empty());
        assertThrows(PersonNotFoundException.class, ()->personService.findPersonById(id));
        verify(personRepository, times(1)).findById(id);
    }
}
*/
