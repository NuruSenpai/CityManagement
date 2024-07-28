package org.example.citymanagement.service;

import org.example.citymanagement.aspect.EnableLogger;
import org.example.citymanagement.entity.Person;
import org.example.citymanagement.repository.PersonRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Component
public class PrizeAwarder {


    private final PersonRepository personRepository;

    public PrizeAwarder(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Transactional
    @EnableLogger
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
