package com.debin.pokemonsearch.framework.remote

import com.debin.pokemonsearch.framework.network.ApiService
import com.debin.pokemonsearch.pokemonservice.data.datasource.IPokemonDataSource
import com.debin.pokemonsearch.pokemonservice.domain.pokemon.PokemonResponse
import io.reactivex.Single

class PokemonDataSourceImpl(private val apiService: ApiService) : IPokemonDataSource {
    override fun getPokemonAsync(name: String?): Single<PokemonResponse> {
        return apiService.getPokemon(name)
    }
}