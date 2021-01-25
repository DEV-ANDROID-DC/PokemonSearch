package com.debin.pokemonsearch.pokemoncore.interactors

import com.debin.pokemonsearch.pokemoncore.domain.repository.IPokemonCoreRepository
import com.debin.pokemonsearch.pokemoncore.domain.repository.Pokemon

class AddToFavourites(private val coreRepository: IPokemonCoreRepository) {
    suspend fun invokeAddToFavourites(pokemon: Pokemon) {
        coreRepository.addPokemonToFavourites(pokemon)
    }
}