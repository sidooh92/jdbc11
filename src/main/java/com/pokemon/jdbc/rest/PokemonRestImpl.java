package com.pokemon.jdbc.rest;

import com.pokemon.jdbc.dto.PokemonDto;
import com.pokemon.jdbc.exception.RestPokemonException;
import com.pokemon.jdbc.service.PokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.List;


@RestController
public class PokemonRestImpl implements PokemonRest {

    private PokemonService pokemonService;

    @Autowired
    public PokemonRestImpl(PokemonService pokemonService) {
        this.pokemonService = pokemonService;
    }

    @GetMapping("/findById")
    @Override
    public ResponseEntity<PokemonDto> findById(int id) {
        return null;
    }

    @GetMapping("/findByName")
    @Override
    public ResponseEntity<PokemonDto> findByName(String name) {
        return null;
    }

    @GetMapping("/findAll")
    @Override
    public ResponseEntity<List<PokemonDto>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(pokemonService.findAll());
    }

    @PostMapping("/addNewPokemon")
    @Override
    public ResponseEntity<Integer> addNewPokemon(@RequestBody PokemonDto pokemonDto) throws RestPokemonException {

        int i = pokemonService.addNewPokemon(pokemonDto);
        if (i < 0) throw new RestPokemonException();
        return ResponseEntity.status(HttpStatus.CREATED).body(i);
    }

    @GetMapping("/count")
    @Override
    public ResponseEntity<Integer> count() {
        return null;
    }

    @DeleteMapping("/delete")
    @Override
    public ResponseEntity<Void> delete(int id) {
        return null;
    }
}
