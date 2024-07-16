package org.example.citymanagement.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CarDTO {
    private Long id;
    private String brand;
    private String model;
    private String color;

    @Override
    public String toString(){
        return "CarDTO{" +
                "id='" + id + '\'' +
                " brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", year=" + color +
                '}';
    }
}
