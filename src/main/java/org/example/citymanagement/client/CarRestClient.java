//package org.example.citymanagement.client;
//
//import lombok.RequiredArgsConstructor;
//
//import org.springframework.context.annotation.Profile;
//import org.springframework.stereotype.Component;
//import org.springframework.web.client.RestTemplate;
//
//import java.util.Collections;
//import java.util.List;
//
//@Profile("rest")
//@RequiredArgsConstructor
//@Component
//public class CarRestClient implements CarClient {
//    private final RestTemplate restTemplate;
//
//    @Override
//    public List<CarDTO> getAllCarsByPersonId(Long id) {
//        String url = "http://CarServer/cars/persons/" + id;
//        CarDTO[] cars = restTemplate.getForObject(url, CarDTO[].class);
//
//        if (cars == null) {
//            return Collections.emptyList();
//        }
//
//        return List.of(cars);
//    }
//
//    @Override
//    public org.example.api.DTO.CarDTO createCar(org.example.api.DTO.CarDTO carDTO) {
//        return null;
//    }
//
//    @Override
//    public org.example.api.DTO.CarDTO getCarById(Long id) {
//        return null;
//    }
//
//    @Override
//    public void deleteCarById(Long id) {
//
//    }
//
//    @Override
//    public org.example.api.DTO.CarDTO updateCar(Long id, org.example.api.DTO.CarDTO carDTO) {
//        return null;
//    }
//
//}
