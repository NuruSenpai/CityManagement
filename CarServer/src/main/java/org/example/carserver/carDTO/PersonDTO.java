package org.example.carserver.carDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.example.carserver.enums.PersonStatus;
import org.example.carserver.enums.SexType;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
public class PersonDTO {
    private Long id;
    private String name;
    private String surname;
    private BigDecimal balance;

    private PersonStatus status;

    private SexType sexType;
}
