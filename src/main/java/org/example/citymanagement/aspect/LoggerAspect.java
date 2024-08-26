package org.example.citymanagement.aspect;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.example.api.DTO.CarDTO;
import org.example.citymanagement.client.CarClient;
import org.example.citymanagement.entity.Person;
import org.example.citymanagement.repository.PersonRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Random;

@RequiredArgsConstructor
@Aspect
@Component
@Slf4j
public class LoggerAspect {

    private final CarClient carClient;
    private final PersonRepository personRepository;
    private final Random random = new Random();


    @Around("@annotation(org.example.citymanagement.aspect.Robingood)")
    public Object checkWinnerCar(ProceedingJoinPoint joinPoint) throws Throwable {
        Object[] args = joinPoint.getArgs();
        for (Object arg : args) {
            if (arg instanceof Person winner) {
                List<CarDTO> cars = carClient.getAllCarsByPersonId(winner.getId());
                if (!cars.isEmpty()) {
                    log.info("У {} есть машина", winner.getName());

                    List<Person> persons = personRepository.findAll();
                    List<Person> personsWithoutCars = persons.stream()
                            .filter(person -> carClient.getAllCarsByPersonId(person.getId()).isEmpty())
                            .toList();

                    if (!personsWithoutCars.isEmpty()) {
                        Person newWinner = personsWithoutCars.get(random.nextInt(personsWithoutCars.size()));
                        log.info("Робингуд, дал деньги {}", newWinner.getName());
                        args[0] = newWinner;
                    } else {
                        log.info("у всех жителей есть машины");
                        return null;
                    }
                }
            }

        }
        return joinPoint.proceed(args);
    }
}
