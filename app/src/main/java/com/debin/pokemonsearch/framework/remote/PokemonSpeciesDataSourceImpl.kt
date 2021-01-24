package com.debin.pokemonsearch.framework.remote

import com.debin.pokemonsearch.framework.network.ApiService
import com.debin.pokemonsearch.pokemonservice.data.datasource.IPokemonSpeciesDataSource
import com.debin.pokemonsearch.pokemonservice.data.models.pokemonSpeciesEntity.PokemonSpeciesResponseEntity
import io.reactivex.Single

class PokemonSpeciesDataSourceImpl(private val apiService: ApiService) : IPokemonSpeciesDataSource {
    override fun getPokemonSpeciesAsync(name: String?): Single<PokemonSpeciesResponseEntity> {
        return apiService.getPokemonSpecies(name)
    }
}