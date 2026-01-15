package com.tesys.netwebpage.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.ManyToOne;

@Entity
@Table(name = "favourite_characters")
public class FavouriteCharacter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer characterId; // ID de Rick & Morty
    private String name;
    private String image;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
