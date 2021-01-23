package com.debin.pokemonsearch.pokemoncore.interactors

import com.debin.pokemonsearch.pokemoncore.data.repository.PokemonCoreRepository
import com.debin.pokemonsearch.pokemoncore.domain.repository.Pokemon

class AddToFavourites(private val coreRepository: PokemonCoreRepository) {
    suspend fun invokeAddToFavourites(pokemon: Pokemon) {
        coreRepository.addPokemonToFavourites(pokemon)
    }
}