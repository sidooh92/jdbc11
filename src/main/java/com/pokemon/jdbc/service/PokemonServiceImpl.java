package com.pokemon.jdbc.service;

import com.pokemon.jdbc.domain.PokemonDomain;
import com.pokemon.jdbc.dto.PokemonDto;
import com.pokemon.jdbc.dto.SpeciesDto;
import com.pokemon.jdbc.mapper.PokemonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PokemonServiceImpl implements PokemonService {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public PokemonServiceImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public PokemonDto findById(int id) {
        PokemonDomain query;
        try {
            query = this.jdbcTemplate.queryForObject(
                    "SELECT * FROM pokemons WHERE idPokemon = ?", new PokemonMapper(), id);
            return convertPokemonToDto(query);

        } catch (Exception e) {
            e.printStackTrace(); //log.error("Couldn't find pokemon");
        }
        return null;
    }

    @Override
    public PokemonDto findByName(String name) {
        return null;
    }

    @Override
    public List<PokemonDto> findAll() {

        List<PokemonDomain> pokemonDomainList = jdbcTemplate
                .query("SELECT idPokemon, name, weight, speciesUrl, speciesName from pokemons",
                new PokemonMapper());

     return pokemonDomainList
             .stream()
             .map(this::convertPokemonToDto)
             .collect(Collectors.toList());
    }

    private PokemonDto convertPokemonToDto(PokemonDomain pok) {
       return new PokemonDto(pok.getName(),String.valueOf(pok.getWeight()),
               new SpeciesDto(pok.getSpeciesUrl(),pok.getSpeciesName()));
    }

    @Override
    public int addNewPokemon(PokemonDto pokemonDto) {
        return jdbcTemplate.update("INSERT INTO pokemons(name, weight, speciesUrl, speciesName)" +
                        " VALUES(?,?,?,?)", pokemonDto.getName(), pokemonDto.getWeight(),
                pokemonDto.getSpecies().getUrl(), pokemonDto.getSpecies().getName());
    }

    @Override
    public int count() {

        return this.jdbcTemplate.queryForObject(
                "select count(*) from pokemons", Integer.class);


    }

    @Override
    public void delete(int id) {

    }
}
