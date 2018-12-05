package com.pokemon.jdbc.rest;

import com.pokemon.jdbc.dto.PokemonDto;
import com.pokemon.jdbc.exception.RestPokemonException;
import com.pokemon.jdbc.service.PokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;


@RestController
@RequestMapping("/api")
public class PokemonRestImpl implements PokemonRest {

    private PokemonService pokemonService;

    @Autowired
    public PokemonRestImpl(PokemonService pokemonService) {
        this.pokemonService = pokemonService;
    }

    @GetMapping("/findById")
    @Override
    public ResponseEntity<PokemonDto> findById(int id) throws RestNotFoundPokemonException {

        PokemonDto byId = pokemonService.findById(id);

        if (byId != null) {
            byId.add(linkTo(methodOn(PokemonRestImpl.class).count()).withSelfRel());
            return ResponseEntity.status(HttpStatus.OK).body(byId);
        } else {
            throw new RestNotFoundPokemonException();
        }

    }

    @GetMapping("/findByName")
    @Override
    public ResponseEntity<PokemonDto> findByName(String name) throws RestNotFoundPokemonException {

       return pokemonService.findByName(name)
               .map(p -> ResponseEntity.status(HttpStatus.OK).body(p))
               .orElseThrow(() -> new RestNotFoundPokemonException());



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

      return   ResponseEntity.status(HttpStatus.OK).body(pokemonService.count());
    }

    @DeleteMapping("/delete")
    @Override
    public ResponseEntity<Void> delete(int id) {
        return null;
    }
}
