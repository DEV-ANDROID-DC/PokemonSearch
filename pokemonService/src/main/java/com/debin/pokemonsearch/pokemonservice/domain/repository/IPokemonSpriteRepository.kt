package com.debin.pokemonsearch.pokemonservice.domain.repository

import com.debin.pokemonsearch.pokemonservice.domain.pokemon.PokemonResponse
import io.reactivex.Single

interface IPokemonSpriteRepository {
    fun getPokemon(name:String) : Single<PokemonResponse>
}