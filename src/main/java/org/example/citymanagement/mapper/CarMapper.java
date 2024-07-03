package org.example.citymanagement.mapper;

import org.example.citymanagement.DTO.CarDTO;
import org.example.citymanagement.DTO.HomeDTO;
import org.example.citymanagement.entity.Car;
import org.example.citymanagement.entity.Home;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CarMapper {
    CarMapper INSTANCE = Mappers.getMapper(CarMapper.class);

    CarDTO carToCarDTO(Car car);

    Car carDTOToCar(CarDTO carDTO);

    List<CarDTO> carListToCarDTOList(List<Car> car);
}
