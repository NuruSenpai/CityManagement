package org.example.api.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.example.api.enums.SexType;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
public class PersonDTO {
    private Long id;
    private String name;
    private String surname;
    private BigDecimal balance;
    private SexType sexType;
}
