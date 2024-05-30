package org.example.citymanagement.mapper;

import org.example.citymanagement.DTO.CarDTO;
import org.example.citymanagement.entity.Car;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CarMapper {
    CarMapper INSTANCE = Mappers.getMapper(CarMapper.class);

    CarDTO carToCarDTO(Car car);

    Car carDTOToCar(CarDTO carDTO);
}
