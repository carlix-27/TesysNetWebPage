package com.tesys.netwebpage.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tesys.netwebpage.exception.CharacterNotFoundException;
import com.tesys.netwebpage.repository.CharacterRepository;

@RestController
@RequestMapping("/character")
public class CharacterController {

    private final CharacterRepository characterRepository;
    
    CharacterController(CharacterRepository characterRepository){
        this.characterRepository = characterRepository;
    }

    @GetMapping
    public List<Character> getAllCharacters(){
        return characterRepository.findAll();
    }

    @GetMapping("/{id}")
    public Character getCharacterById(
        @PathVariable Long id 
    ){
        return characterRepository.findById(id)
            .orElseThrow(() -> new CharacterNotFoundException(id));
    }

    //@PostMapping
    // @PutMapping
    // @DeleteMapping
}
