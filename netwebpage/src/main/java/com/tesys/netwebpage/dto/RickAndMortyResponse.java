package com.tesys.netwebpage.dto;

import java.util.List;

public class RickAndMortyResponse {
    private List<CharacterApiDto> results;

    // este le pega a /characters de nuestra api
    public List<CharacterApiDto> getResults(){
        return results;
    }
}
