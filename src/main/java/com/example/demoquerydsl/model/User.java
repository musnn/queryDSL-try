package com.example.demoquerydsl.model;

import javax.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "USER")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User {

    @Id
    @Column(name = "ID")
    @SequenceGenerator(name = "USER_GENERATOR", sequenceName = "USER_SEQ")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USER_GENERATOR")
    private Long id;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;

    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "user")
    private List<Order> orders;
}
