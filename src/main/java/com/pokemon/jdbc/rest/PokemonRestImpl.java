package com.pokemon.jdbc.rest;

import com.pokemon.jdbc.dto.PokemonDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class PokemonRestImpl implements PokemonRest{



    @Override
    public ResponseEntity<PokemonDto> findById(int id) {
        return null;
    }

    @Override
    public ResponseEntity<PokemonDto> findByName(String name) {
        return null;
    }

    @Override
    public ResponseEntity<List<PokemonDto>> findAll() {
        return null;
    }

    @Override
    public ResponseEntity<Integer> addNewPokemon(PokemonDto pokemonDto) {
        return null;
    }

    @Override
    public ResponseEntity<Integer> count() {
        return null;
    }

    @Override
    public ResponseEntity<Void> delete(int id) {
        return null;
    }
}
