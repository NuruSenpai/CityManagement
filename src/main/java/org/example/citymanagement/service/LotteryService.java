package org.example.citymanagement.service;


import org.example.citymanagement.entity.Person;
import org.example.citymanagement.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class LotteryService {

    private PersonRepository personRepository;

    private PrizeAwarder prizeAwarder;

    @Autowired
    public LotteryService(PersonRepository personRepository, PrizeAwarder prizeAwarder) {
        this.personRepository = personRepository;
        this.prizeAwarder = prizeAwarder;
    }

    private final Random random = new Random();

    @Scheduled(fixedRate = 5000)
    public void runLottery(){
        List<Person> persons = personRepository.findAll();
        if(!persons.isEmpty()){
            Person winner = persons.get(random.nextInt(persons.size()));
            prizeAwarder.awardPrize(winner);
        }

    }


}
