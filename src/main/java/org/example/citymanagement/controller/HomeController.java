package org.example.citymanagement.controller;


import lombok.RequiredArgsConstructor;
import org.example.citymanagement.DTO.HomeDTO;
import org.example.citymanagement.entity.Home;
import org.example.citymanagement.mapper.HomeMapper;
import org.example.citymanagement.service.HomeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/homes")
public class HomeController implements org.example.citymanagement.controller.controllerInterface.HomeController {
    private final HomeService homeService;

    @PostMapping("/create")
    public HomeDTO createHome(@RequestBody HomeDTO homeDTO) {
        Home home = HomeMapper.INSTANCE.homeDTOToHome(homeDTO);
        return HomeMapper.INSTANCE.homeToHomeDTO(homeService.createHome(home));
    }

    @GetMapping("/get/{id}")
    public HomeDTO getHomeById(@PathVariable Long id) {
        return HomeMapper.INSTANCE.homeToHomeDTO(homeService.findHomeById(id));
    }

    @DeleteMapping("/delete/{id}")
    public void deleteHomeById(@PathVariable Long id) {
        homeService.deleteHomeById(id);
    }

    @GetMapping("/get-all")
    public List<HomeDTO> getAllHomesByStreet(@RequestParam String street){
        return HomeMapper.INSTANCE.homeListToHomeDTOList(homeService.findAllHomeByStreet(street));
    }
}
