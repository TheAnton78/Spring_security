package ru.netology.sql_hibirnate.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.sql_hibirnate.model.Person;
import ru.netology.sql_hibirnate.repository.Repository;

import java.util.ArrayList;
import java.util.List;

@RestController
public class Controller {
    Repository repository;

    public Controller(Repository repository){
        this.repository = repository;
    }

    @GetMapping("/persons/by-city")
    public List<Person> getPersonsByCity(String city){
        List<?> persons = repository.getPersonsByCity(city);
        return (List<Person>) persons;
    }
}
