package com.debin.pokemonsearch.pokemoncore.interactors

import com.debin.pokemonsearch.pokemoncore.domain.repository.IPokemonCoreRepository
import com.debin.pokemonsearch.pokemoncore.domain.repository.Pokemon

private const val TAG = "AddToFavourites"
open class AddToFavourites(private val coreRepository: IPokemonCoreRepository) {
    suspend fun invokeAddToFavourites(pokemon: Pokemon) {
        println("$TAG :: Pokemon :: $pokemon")
        coreRepository.addPokemonToFavourites(pokemon)
    }
}