package com.pokemon.jdbc.domain;

public class PokemonDomain {

    private int idPokemon;
    private String name;
    private int weight;
    private String speciesUrl;
    private String speciesName;

    public PokemonDomain(int idPokemon, String name, int weight, String speciesUrl, String speciesName) {
        this.idPokemon = idPokemon;
        this.name = name;
        this.weight = weight;
        this.speciesUrl = speciesUrl;
        this.speciesName = speciesName;
    }

    public PokemonDomain() {
    }

    public int getIdPokemon() {
        return idPokemon;
    }

    public void setIdPokemon(int idPokemon) {
        this.idPokemon = idPokemon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getSpeciesUrl() {
        return speciesUrl;
    }

    public void setSpeciesUrl(String speciesUrl) {
        this.speciesUrl = speciesUrl;
    }

    public String getSpeciesName() {
        return speciesName;
    }

    public void setSpeciesName(String speciesName) {
        this.speciesName = speciesName;
    }
}
