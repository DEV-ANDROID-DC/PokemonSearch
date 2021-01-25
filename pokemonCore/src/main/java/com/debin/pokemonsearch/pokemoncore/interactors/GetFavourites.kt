package com.debin.pokemonsearch.pokemoncore.interactors

import com.debin.pokemonsearch.pokemoncore.data.repository.PokemonCoreRepository
import com.debin.pokemonsearch.pokemoncore.domain.repository.IPokemonCoreRepository

class GetFavourites(private val coreRepository: IPokemonCoreRepository) {
    suspend fun invokeGetFavourites() {
        coreRepository.getFavouritePokemon()
    }
}