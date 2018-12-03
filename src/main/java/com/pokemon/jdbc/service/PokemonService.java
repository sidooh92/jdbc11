package com.pokemon.jdbc.service;

import com.pokemon.jdbc.dto.PokemonDto;

import java.util.List;

public interface PokemonService {


    PokemonDto findById(int id);
    PokemonDto findByName(String name);
    List<PokemonDto> findAll();
    int addNewPokemon(PokemonDto pokemonDto);
    int count();
    void delete(int id);



}
