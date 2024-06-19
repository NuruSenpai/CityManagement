package org.example.citymanagement.controller.controllerInterface;

import org.example.citymanagement.DTO.HomeDTO;
import org.example.citymanagement.entity.Home;
import org.springframework.web.bind.annotation.*;

public interface HomeController {
    @PostMapping("/create")
    public HomeDTO createHome(@RequestBody HomeDTO homeDTO);

    @GetMapping("/get/{id}")
    public Home getHomeById(@PathVariable Long id);

    @DeleteMapping("/delete/{id}")
    public void deleteHomeById(@PathVariable Long id);
}
