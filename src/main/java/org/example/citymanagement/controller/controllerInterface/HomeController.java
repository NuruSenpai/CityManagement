package org.example.citymanagement.controller.controllerInterface;

import org.example.citymanagement.DTO.HomeDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface HomeController {
    @PostMapping("/create")
    HomeDTO createHome(@RequestBody HomeDTO homeDTO);

    @GetMapping("/get/{id}")
    HomeDTO getHomeById(@PathVariable Long id);

    @DeleteMapping("/delete/{id}")
    void deleteHomeById(@PathVariable Long id);

    @GetMapping("/get-all")
    List<HomeDTO> getAllHomesByStreet(@RequestParam String street);
}
