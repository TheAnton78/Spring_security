package ru.netology.sql_hibirnate;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SqlHibirnateApplication {



	public static void main(String[] args) {
		SpringApplication.run(SqlHibirnateApplication.class, args);
	}

}
