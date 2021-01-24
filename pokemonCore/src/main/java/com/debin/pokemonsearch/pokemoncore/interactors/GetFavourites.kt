package com.debin.pokemonsearch.pokemoncore.interactors

import com.debin.pokemonsearch.pokemoncore.data.repository.PokemonCoreRepository

class GetFavourites(private val coreRepository: PokemonCoreRepository) {
    suspend fun invokeGetFavourites() {
        coreRepository.getFavouritePokemon()
    }
}