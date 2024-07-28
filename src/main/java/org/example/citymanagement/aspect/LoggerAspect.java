package org.example.citymanagement.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.example.citymanagement.entity.Car;
import org.example.citymanagement.entity.Person;
import org.example.citymanagement.repository.PersonRepository;
import org.example.citymanagement.service.CarService;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Random;

@Aspect
@Component
@Slf4j
public class LoggerAspect {

    private final CarService carService;
    private final PersonRepository personRepository;

    public LoggerAspect(CarService carService, PersonRepository personRepository) {
        this.carService = carService;
        this.personRepository = personRepository;
    }

    private final Random random = new Random();



    @Around("@annotation(org.example.citymanagement.aspect.EnableLogger)")
    public Object checkWinnerCar(ProceedingJoinPoint joinPoint) throws Throwable {
        Object[] args = joinPoint.getArgs();
        for (Object arg : args) {
            if (arg instanceof Person winner) {
                List<Car> cars = carService.findCarsByPersonId(winner.getId());
                if (!cars.isEmpty()) {
                    log.info("У {} есть машина", winner.getName());

                    List<Person> persons = personRepository.findAll();
                    List<Person> personsWithoutCars = persons.stream()
                            .filter(person -> carService.findCarsByPersonId(person.getId()).isEmpty())
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
