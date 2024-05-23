package ru.netology.sql_hibirnate.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

import java.io.Serializable;

@Data
@Embeddable
public class CompositeKey implements Serializable {
    @Column(nullable = false, length = 25)
    private String name;
    @Column(nullable = false, length = 25)
    private String surname;
    @Column(nullable = false)
    private Integer age;

}
