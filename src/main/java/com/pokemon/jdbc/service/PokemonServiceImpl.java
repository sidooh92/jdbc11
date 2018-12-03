package com.pokemon.jdbc.service;

import com.pokemon.jdbc.dto.PokemonDto;
import com.pokemon.jdbc.rest.PokemonRest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PokemonServiceImpl implements PokemonService {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public PokemonServiceImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public PokemonDto findById(int id) {
        return null;
    }

    @Override
    public PokemonDto findByName(String name) {
        return null;
    }

    @Override
    public List<PokemonDto> findAll() {
        return null;
    }

    @Override
    public int addNewPokemon(PokemonDto pokemonDto) {
        return 0;
    }

    @Override
    public int count() {
        return 0;
    }

    @Override
    public void delete(int id) {

    }
}
