package com.debin.pokemonsearch.framework.core

import com.debin.pokemonsearch.framework.db.PokemonDatabase
import com.debin.pokemonsearch.framework.db.PokemonFavouriteEntity
import com.debin.pokemonsearch.pokemoncore.data.datasource.PokemonCoreDataSource
import com.debin.pokemonsearch.pokemoncore.domain.repository.Pokemon

class PokemonCoreDataSourceImpl(private val database : PokemonDatabase) : PokemonCoreDataSource{

    override suspend fun addPokemonToFavourites(pokemon: Pokemon) {
        return database.pfDao.addToFavourite(PokemonFavouriteEntity(id = pokemon.id, name = pokemon.name,
        description = pokemon.description, imageUrl = pokemon.imageUrl))
    }

    override suspend fun getFavouritePokemon(): List<Pokemon> {
        return database.pfDao.getFavouritePokemon().map {
          Pokemon(id = it.id, name = it.name, description = it.description, imageUrl = it.imageUrl)
        }
    }

    override suspend fun removePokemonFromFavourite(pokemon: Pokemon) {
          return database.pfDao.removeFromFavourite(PokemonFavouriteEntity(
              id = pokemon.id, name = pokemon.name,
              description = pokemon.description, imageUrl = pokemon.imageUrl
          ))
    }
}