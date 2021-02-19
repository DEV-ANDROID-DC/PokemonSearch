package com.debin.pokemonsearch.pokemoncore.interactors

import com.debin.pokemonsearch.pokemoncore.data.repository.PokemonCoreRepository
import com.debin.pokemonsearch.pokemoncore.domain.repository.IPokemonCoreRepository
import com.debin.pokemonsearch.pokemoncore.domain.repository.Pokemon
import com.debin.pokemonsearch.pokemoncore.utils.Resource
import com.debin.pokemonsearch.pokemoncore.utils.StateResponse
import kotlinx.coroutines.flow.Flow

class GetFavourites(private val coreRepository: IPokemonCoreRepository) {
    suspend fun invokeGetFavourites() : Flow<StateResponse<List<Pokemon>>> {
      return coreRepository.getFavouritePokemon()
    }
}