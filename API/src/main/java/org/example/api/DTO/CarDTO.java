package org.example.api.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.example.api.enums.CarStatus;

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
                ", year=" + color +
                '}';
    }
}
