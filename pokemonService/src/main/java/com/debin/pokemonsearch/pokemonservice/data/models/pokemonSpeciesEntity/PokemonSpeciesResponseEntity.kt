package com.debin.pokemonsearch.pokemonservice.data.models.pokemonSpeciesEntity

import com.debin.pokemonsearch.pokemonservice.domain.pokemonspices.FlavorTextEntry

data class PokemonSpeciesResponseEntity(
    val flavor_text_entries: List<FlavorTextEntryEntity>,
    val id: Int,
    val name: String
)