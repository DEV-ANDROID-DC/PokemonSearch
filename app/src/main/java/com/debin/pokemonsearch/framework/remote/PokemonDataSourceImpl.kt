package com.debin.pokemonsearch.framework.remote

import com.debin.pokemonsearch.framework.network.ApiService
import com.debin.pokemonsearch.pokemonservice.data.datasource.IPokemonDataSource
import com.debin.pokemonsearch.pokemonservice.data.models.pokemonEntity.PokemonResponseEntity
import io.reactivex.Single

class PokemonDataSourceImpl(private val apiService: ApiService) : IPokemonDataSource {
    override fun getPokemonAsync(name: String?): Single<PokemonResponseEntity> {
        return apiService.getPokemon(name)
    }
}