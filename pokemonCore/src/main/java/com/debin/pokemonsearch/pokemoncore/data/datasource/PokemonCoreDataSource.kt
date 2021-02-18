package com.debin.pokemonsearch.pokemoncore.data.datasource

import com.debin.pokemonsearch.pokemoncore.data.model.PokemonCoreEntity
import com.debin.pokemonsearch.pokemoncore.domain.repository.Pokemon
import com.debin.pokemonsearch.pokemoncore.utils.Resource
import com.debin.pokemonsearch.pokemoncore.utils.StateResponse
import kotlinx.coroutines.flow.Flow

interface PokemonCoreDataSource {
    suspend fun addPokemonToFavourites(pokemon: Pokemon)
    suspend fun getFavouritePokemon() : Flow<StateResponse<List<Pokemon>>>
    suspend fun removePokemonFromFavourite(pokemon: Pokemon)
}