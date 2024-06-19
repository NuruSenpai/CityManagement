package org.example.citymanagement.service.serviceInterface;

import org.example.citymanagement.entity.Home;

import java.util.List;

public interface HomeService {

    Home createHome(Home home);

    Home findHomeById(Long id);

    void deleteHomeById(Long id);

    List<Home> findAllHomeByStreet(String street);

}
