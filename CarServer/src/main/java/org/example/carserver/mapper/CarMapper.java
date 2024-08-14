package org.example.carserver.mapper;

import org.example.carserver.carDTO.CarDTO;
import org.example.carserver.entity.Car;
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
