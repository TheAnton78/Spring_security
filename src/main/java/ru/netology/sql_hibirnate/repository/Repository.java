package ru.netology.sql_hibirnate.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import ru.netology.sql_hibirnate.model.Person;

import java.util.List;

@org.springframework.stereotype.Repository
public class Repository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<?> getPersonsByCity(String city){
        return (List<?>) entityManager.createQuery("SELECT person from Person person where cityOfLiving = ?1")
                .setParameter(1, city.toUpperCase()).getResultList();
    }

}
