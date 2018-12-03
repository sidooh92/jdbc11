package com.pokemon.jdbc.dto;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PokemonDto {

    private String name;
    private String weight;
    private SpeciesDto species;

    public PokemonDto() {
    }

    public PokemonDto(String name, String weight, SpeciesDto species) {
        this.name = name;
        this.weight = weight;
        this.species = species;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public SpeciesDto getSpecies() {
        return species;
    }

    public void setSpecies(SpeciesDto species) {
        this.species = species;
    }
}
