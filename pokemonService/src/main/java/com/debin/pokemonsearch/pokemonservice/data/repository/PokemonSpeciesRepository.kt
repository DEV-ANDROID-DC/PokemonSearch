package com.debin.pokemonsearch.pokemonservice.data.repository

import com.debin.pokemonsearch.pokemonservice.data.datasource.IPokemonSpeciesDataSource
import com.debin.pokemonsearch.pokemonservice.domain.pokemonspices.PokemonSpeciesResponse
import com.debin.pokemonsearch.pokemonservice.domain.repository.IPokemonSpeciesRepository
import io.reactivex.Single

class PokemonSpeciesRepository(private val dataSource: IPokemonSpeciesDataSource) : IPokemonSpeciesRepository {
    override fun getPokemonSpecies(name: String?): Single<PokemonSpeciesResponse> {
        return dataSource.getPokemonSpeciesAsync(name)
    }
}