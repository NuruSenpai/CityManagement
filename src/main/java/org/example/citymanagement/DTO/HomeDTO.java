package org.example.citymanagement.DTO;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class HomeDTO {
    private long id;
    private String address;
    private int numberOfRooms;
}
