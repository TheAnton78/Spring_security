package ru.netology.sql_hibirnate.controller;

import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.sql_hibirnate.model.CompositeKey;
import ru.netology.sql_hibirnate.model.Person;
import ru.netology.sql_hibirnate.repository.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/persons")
public class Controller {
    Repository repository;

    public Controller(Repository repository){
        this.repository = repository;
    }

    @GetMapping("/by-id")
    public Person findById(String name, String surname, Integer age){
        CompositeKey compositeKey = new CompositeKey();
        compositeKey.setName(name);
        compositeKey.setSurname(surname);
        compositeKey.setAge(age);
        return repository.findById(compositeKey).orElse(null);
    }

    @GetMapping("/by-city")
    public List<Person> getPersonsByCity(String city){
        List<?> persons = repository.findByCityOfLiving(city);
        return (List<Person>) persons;
    }

    @GetMapping("/less-age")
    public List<Person> getPersonsLessAge(Integer age){
        return repository.findByIdAgeLessThanOrderByIdAge(age);

    }

    @GetMapping("/by-name-surname")
    public List<Person> getPersonsByNameSurname(String name, String surname){
        return repository.findByIdNameAndIdSurnameLike(name, surname);
    }


}
