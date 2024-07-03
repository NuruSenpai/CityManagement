package org.example.citymanagement.service;


import lombok.RequiredArgsConstructor;
import org.example.citymanagement.entity.Home;
import org.example.citymanagement.repository.HomeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class HomeService implements org.example.citymanagement.service.serviceInterface.HomeService {
private final HomeRepository homeRepository;

public Home createHome(Home home){
    return homeRepository.save(home);
}

public Home findHomeById(Long id){
    return homeRepository.findById(id).orElse(null);
}

public void deleteHomeById(Long id){
    homeRepository.deleteById(id);
}

public List<Home> findAllHomeByStreet(String street){
    return homeRepository.findAllByStreet("%" + street + "%");

}

}
