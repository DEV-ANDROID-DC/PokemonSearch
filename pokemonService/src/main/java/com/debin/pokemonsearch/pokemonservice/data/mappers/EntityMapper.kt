package com.debin.pokemonsearch.pokemonservice.data.mappers

import com.debin.pokemonsearch.pokemonservice.domain.pokemon.Sprites

/**
 * Interface for model mappers. It provides helper methods that facilitate
 * retrieving of models from outer data source layers
 *
 * @param <M> the remote model out type
 * @param <E> the entity model input type
 */
abstract class EntityMapper<in E, out M> {

  abstract fun mapFromRemote(type : E) : M

  fun mapFromRemote(type: List<E>) : List<M> {
      val list = ArrayList<M>()
      type.forEach{item->
       list.add(mapFromRemote(item))
      }
      return list
  }
}