package org.example.citymanagement.mapper;


import org.example.citymanagement.DTO.PersonDTO;
import org.example.citymanagement.entity.Person;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PersonMapper {
    PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);

    PersonDTO personToPersonDTO(Person person);

    Person personDTOToPerson(PersonDTO personDTO);

    List<PersonDTO> personListToPersonDTOList(List<Person> personList);

}
