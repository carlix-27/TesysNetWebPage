package com.tesys.netwebpage.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.tesys.netwebpage.dto.CharacterApiDto;
import com.tesys.netwebpage.dto.RickAndMortyResponse;
import com.tesys.netwebpage.exception.CharacterNotFoundException;


// Este servicio me permite comunicarme con la API externa de Rick y Morty
@Service
public class CharacterService {
    
    private final RestTemplate restTemplate = new RestTemplate();

    // aca me comunico con la api externa para traer a todos los personajes!
    public List<CharacterApiDto> getCharacters() {
        RickAndMortyResponse response = 
            restTemplate.getForObject(System.getenv("CHARACTER_URL"), RickAndMortyResponse.class);

        return response.getResults();
    }


    // aca me comunico con la api externa para traer solo un personaje por id!
    public CharacterApiDto getCharacterById(Integer id) {
        try {
            return restTemplate.getForObject(
                System.getenv("CHARACTER_URL") + "/" + id,
                CharacterApiDto.class
            );
        } catch (HttpClientErrorException.NotFound ex) {
            throw new CharacterNotFoundException(id);
        }
    }
}
