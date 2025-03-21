package org.example.citymanagement.mapper;


import org.example.citymanagement.DTO.HomeDTO;
import org.example.citymanagement.entity.Home;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface HomeMapper {
    HomeMapper INSTANCE = Mappers.getMapper(HomeMapper.class);

    HomeDTO homeToHomeDTO(Home home);

    Home homeDTOToHome(HomeDTO homeDTO);

    List<HomeDTO> homeListToHomeDTOList(List<Home> home);
}
