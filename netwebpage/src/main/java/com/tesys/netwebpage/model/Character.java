package com.tesys.netwebpage.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "characters")
public class Character {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id; 
    
    private String name; 

    private String status;

    private String species; 

    private String image; 

    // "urls" list
    private List<String> episode;

}
