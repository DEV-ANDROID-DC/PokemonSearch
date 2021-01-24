package com.debin.pokemonsearch.pokemonservice.data.datasource

import com.debin.pokemonsearch.pokemonservice.data.models.pokemonSpeciesEntity.PokemonSpeciesResponseEntity
import com.debin.pokemonsearch.pokemonservice.domain.pokemonspices.PokemonSpeciesResponse
import io.reactivex.Single

interface IPokemonSpeciesDataSource {
    fun getPokemonSpeciesAsync(name: String?) : Single<PokemonSpeciesResponseEntity>
}