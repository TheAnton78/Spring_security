package ru.netology.sql_hibirnate.controller;

import jakarta.annotation.security.RolesAllowed;
import org.springframework.data.domain.Sort;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
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
    @Secured({"ROLE_READ"})
    public Person findById(String name, String surname, Integer age){
        CompositeKey compositeKey = new CompositeKey();
        compositeKey.setName(name);
        compositeKey.setSurname(surname);
        compositeKey.setAge(age);
        return repository.findById(compositeKey).orElse(null);
    }

    @PostAuthorize("hasAnyRole('WRITE', 'DELETE')")
    @GetMapping("/by-city")
    public List<Person> getPersonsByCity(String city){
        List<?> persons = repository.findByCityOfLiving(city);
        return (List<Person>) persons;
    }


    @GetMapping("/less-age")
    @RolesAllowed({"ROLE_WRITE"})
    public List<Person> getPersonsLessAge(Integer age){
        return repository.findByIdAgeLessThanOrderByIdAge(age);
    }

    @GetMapping("/by-name")
    @PreAuthorize("#name == authentication.principal.username")
    public List<Person> getPersonsByName(String name){
        return repository.findByIdName(name);
    }

    @GetMapping("/by-name-surname")
    public List<Person> getPersonsByNameSurname(String name, String surname){
        return repository.findByIdNameAndIdSurnameLike(name, surname);
    }


}
