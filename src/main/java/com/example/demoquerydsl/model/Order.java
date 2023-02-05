package com.example.demoquerydsl.model;

import javax.persistence.*;
import lombok.*;

@Entity
@Table(name = "ORDER")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Order {
    @Id
    @Column(name = "ID")
    @SequenceGenerator(name = "ORDER_GENERATOR", sequenceName = "ORDER_SEQ")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ORDER_GENERATOR")
    private Long id;

    @Column(name = "TITLE")
    private String title;

    @ManyToOne
    private User user;
}
