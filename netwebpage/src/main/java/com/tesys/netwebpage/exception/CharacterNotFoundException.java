package com.tesys.netwebpage.exception;

public class CharacterNotFoundException extends RuntimeException {

    public CharacterNotFoundException(Long id) {
        super("Character with id " + id + " not found");
    }
}