package com.debin.pokemonsearch.pokemoncore.interactors

import com.debin.pokemonsearch.pokemoncore.data.repository.PokemonCoreRepository
import com.debin.pokemonsearch.pokemoncore.domain.repository.Pokemon

class RemoveFromFavourite(private val coreRepository: PokemonCoreRepository) {
  suspend fun invokeRemoveFromFavourites(pokemon: Pokemon) {
      coreRepository.removePokemonFromFavourite(pokemon)
  }
}