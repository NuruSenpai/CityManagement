package org.example.citymanagement.service;

import lombok.RequiredArgsConstructor;
import org.example.citymanagement.aspect.Robingood;
import org.example.citymanagement.entity.Person;
import org.example.citymanagement.repository.PersonRepository;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@RequiredArgsConstructor
@Component
public class PrizeAwarder {


    private final PersonRepository personRepository;


    @Robingood
    public void awardPrize(Person winner) {
        BigDecimal prizeAmount = new BigDecimal("100.00");
        if (winner.getBalance() == null) {
            winner.setBalance(BigDecimal.ZERO);
        }

        winner.setBalance(winner.getBalance().add(prizeAmount));
        personRepository.save(winner);
        System.out.println("Поздравляю " + winner.getName() + " с выигрышем: " + prizeAmount + "!");
    }

}
