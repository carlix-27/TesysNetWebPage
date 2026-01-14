package com.tesys.netwebpage.dto;

import java.util.List;

public class RickAndMortyResponse {

    private Info info;
    private List<CharacterApiDto> results;

    public RickAndMortyResponse() {
    }

    public Info getInfo() {
        return info;
    }

    public void setInfo(Info info) {
        this.info = info;
    }

    public List<CharacterApiDto> getResults() {
        return results;
    }

    public void setResults(List<CharacterApiDto> results) {
        this.results = results;
    }
}
