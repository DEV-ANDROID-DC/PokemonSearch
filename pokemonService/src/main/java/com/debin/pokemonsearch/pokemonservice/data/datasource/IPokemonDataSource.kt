package com.debin.pokemonsearch.pokemonservice.data.datasource

import com.debin.pokemonsearch.pokemonservice.data.models.pokemonEntity.PokemonResponseEntity
import io.reactivex.Single

interface IPokemonDataSource {
    fun getPokemonAsync(name:String?) : Single<PokemonResponseEntity>
}