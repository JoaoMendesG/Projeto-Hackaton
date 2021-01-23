package com.orbitallcorp.hack21.cards.domains;

import lombok.Setter;
import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
@Getter
@Setter
public class Card implements Serializable { //the table/entity !

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long cardNumber;
    private String embossName;
    private String customerName;
    private Integer documentNumber;
    private String motherName;
    private String address;
    private String city;
}