package com.tesys.netwebpage.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.tesys.netwebpage.model.Character;
import com.tesys.netwebpage.repository.CharacterRepository;

@RestController
@RequestMapping("/favourites")
public class FavouriteCharacterController {

    private final CharacterRepository characterRepository;

    public FavouriteCharacterController(CharacterRepository characterRepository){
        this.characterRepository = characterRepository;
    }

    @GetMapping
    public List<Character> getMyFavouriteCharacters(){
        return characterRepository.findAll();
    }

    @PostMapping("/{characterId}")
    public void addFavouriteCharacter(){

    }

    @DeleteMapping("/{characterId}")
    public void deleteFavouriteCharacter(){

    }
}