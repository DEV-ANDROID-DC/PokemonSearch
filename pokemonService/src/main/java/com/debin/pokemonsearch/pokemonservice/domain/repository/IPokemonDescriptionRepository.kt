package com.debin.pokemonsearch.pokemonservice.domain.repository

import com.debin.pokemonsearch.pokemonservice.domain.pokemonspices.PokemonSpeciesResponse
import io.reactivex.Single

interface IPokemonDescriptionRepository {
fun getPokemonSpecies(name: String) : Single<PokemonSpeciesResponse>
}