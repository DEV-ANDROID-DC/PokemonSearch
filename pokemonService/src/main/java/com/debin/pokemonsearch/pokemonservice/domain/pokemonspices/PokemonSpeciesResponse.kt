package com.debin.pokemonsearch.pokemonservice.domain.pokemonspices

data class PokemonSpeciesResponse(
    val flavor_text_entries: List<FlavorTextEntry>,
    val id: Int,
    val name: String
)