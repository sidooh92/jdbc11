package com.pokemon.jdbc.rest;

import com.pokemon.jdbc.dto.PokemonDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface PokemonRest {

    ResponseEntity<PokemonDto> findById(int id);
    ResponseEntity<PokemonDto> findByName(String name);
    ResponseEntity<List<PokemonDto>> findAll();
    ResponseEntity<Integer> addNewPokemon(PokemonDto pokemonDto);
    ResponseEntity<Integer> count();
    ResponseEntity<Void> delete(int id);

}
