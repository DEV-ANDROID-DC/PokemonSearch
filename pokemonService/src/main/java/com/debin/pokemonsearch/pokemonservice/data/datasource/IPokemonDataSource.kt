package com.debin.pokemonsearch.pokemonservice.data.datasource

import com.debin.pokemonsearch.pokemonservice.domain.pokemon.PokemonResponse
import io.reactivex.Single

interface IPokemonDataSource {
    fun getPokemonAsync(name:String?) : Single<PokemonResponse>
}