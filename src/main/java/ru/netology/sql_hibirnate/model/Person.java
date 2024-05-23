package ru.netology.sql_hibirnate.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "persons")
public class Person {
    @EmbeddedId
    private CompositeKey id;
    @Column(nullable = false, length = 12)
    private String phoneNumber;
    @Column(nullable = false, length = 25)
    private String cityOfLiving;

}
