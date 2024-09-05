package org.example.citymanagement.client;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CarDTO {
    private Long id;
    private String brand;
    private String model;
    private String color;
    private CarStatus status;

    @Override
    public String toString(){
        return "CarDTO{" +
                "id='" + id + '\'' +
                " brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", color=" + color +
                '}';
    }
}
