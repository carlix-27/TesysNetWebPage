package com.tesys.netwebpage.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tesys.netwebpage.dto.CharacterApiDto;
import com.tesys.netwebpage.exception.CharacterNotFoundException;
import com.tesys.netwebpage.repository.CharacterRepository;
import com.tesys.netwebpage.service.CharacterService;

@RestController
@RequestMapping("/character")
public class CharacterController {

    private final CharacterRepository characterRepository;
    
    private final CharacterService characterService;

    public CharacterController(CharacterService service, CharacterRepository characterRepository){
        this.characterService = service;
        this.characterRepository = characterRepository;
    }

    // Este get siempre debe hacerlo para acceder a todos los personajes
    // API-Externa (todos)
    @GetMapping
    public List<CharacterApiDto> getExternalCharacters(){
        return characterService.getCharacters();
    }

    // API-Externa (por id)
    @GetMapping("/{id}")
    public CharacterApiDto getCharacterById(
        @PathVariable Integer id 
    ){
        return characterService.getCharacterById(id);
    }

    // Funcionalidad propia del "usuario" si queres
    // Esto interactua con lo que sea que guarde en mi db
    // ej. My Favourite Characters
    // Nuestra DB 
    @GetMapping("/favourite")
    public List<Character> getMyFavouriteCharacters(){
        return characterRepository.findAll();
    }

   

    //@PostMapping
    // @PutMapping
    // @DeleteMapping
}
