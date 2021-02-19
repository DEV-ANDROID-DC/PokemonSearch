package com.debin.pokemonsearch.pokemoncore.domain.repository

import com.debin.pokemonsearch.pokemoncore.utils.Resource
import com.debin.pokemonsearch.pokemoncore.utils.StateResponse
import kotlinx.coroutines.flow.Flow

interface IPokemonCoreRepository {
    suspend fun addPokemonToFavourites(pokemon: Pokemon)
    suspend fun getFavouritePokemon() : Flow<StateResponse<List<Pokemon>>>
    suspend fun removePokemonFromFavourite(pokemon: Pokemon)
}