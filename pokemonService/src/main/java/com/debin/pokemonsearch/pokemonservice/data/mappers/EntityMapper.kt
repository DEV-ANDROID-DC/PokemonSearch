package com.debin.pokemonsearch.pokemonservice.data.mappers

import com.debin.pokemonsearch.pokemonservice.domain.pokemon.Sprites

/**
 * Interface for model mappers. It provides helper methods that facilitate
 * retrieving of models from outer data source layers
 *
 * @param <M> the remote model input type
 * @param <E> the entity model output type
 */
abstract class EntityMapper<in E, out M> {

  abstract fun mapFromRemote(type : E) : M


  fun mapSpritesFromRemote(type: E) : M {
      return mapFromRemote(type)
  }
}