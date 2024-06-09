package ru.netology.sql_hibirnate.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.netology.sql_hibirnate.model.CompositeKey;
import ru.netology.sql_hibirnate.model.Person;

import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Repository
public interface Repository extends JpaRepository<Person, CompositeKey> {
    List<Person> findByCityOfLiving(String cityOfLiving);

    List<Person> findByIdAgeLessThanOrderByIdAge(Integer age);

    List<Person> findByIdNameAndIdSurnameLike(String name, String surname);

//    @PersistenceContext
//    private EntityManager entityManager;
//
//    public List<?> getPersonsByCity(String city){
//        return (List<?>) entityManager.createQuery("SELECT person from Person person where cityOfLiving = ?1")
//                .setParameter(1, city.toUpperCase()).getResultList();
//    }

}
