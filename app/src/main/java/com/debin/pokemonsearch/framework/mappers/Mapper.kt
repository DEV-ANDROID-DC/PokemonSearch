package com.debin.pokemonsearch.framework.mappers

import com.debin.pokemonsearch.framework.db.PokemonFavouriteEntity
import com.debin.pokemonsearch.pokemoncore.domain.repository.Pokemon

fun List<PokemonFavouriteEntity>.asDomainModel() : List<Pokemon> {
      return map {
          Pokemon(id = it.id, name = it.name, description = it.description, imageUrl = it.imageUrl)
      }
}