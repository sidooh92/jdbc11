package com.pokemon.jdbc.mapper;

import com.pokemon.jdbc.domain.PokemonDomain;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class PokemonMapper implements RowMapper<PokemonDomain> {

    @Override
    public PokemonDomain mapRow(ResultSet rs, int i) throws SQLException {
        PokemonDomain pokemonDomain = new PokemonDomain();

        pokemonDomain.setIdPokemon(rs.getInt("idPokemon"));
        pokemonDomain.setName(rs.getString("name"));
        pokemonDomain.setWeight(Integer.parseInt(rs.getString("weight")));
        pokemonDomain.setSpeciesUrl(rs.getString("speciesUrl"));
        pokemonDomain.setSpeciesName(rs.getString("speciesName"));
        return pokemonDomain;
    }
}
