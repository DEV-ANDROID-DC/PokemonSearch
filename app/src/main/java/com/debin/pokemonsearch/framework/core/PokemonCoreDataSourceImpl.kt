package com.debin.pokemonsearch.framework.core

import com.debin.pokemonsearch.framework.db.PokemonDatabase
import com.debin.pokemonsearch.framework.db.PokemonFavouriteEntity
import com.debin.pokemonsearch.framework.mappers.asDomainModel
import com.debin.pokemonsearch.pokemoncore.data.datasource.PokemonCoreDataSource
import com.debin.pokemonsearch.pokemoncore.domain.repository.Pokemon
import com.debin.pokemonsearch.pokemoncore.utils.Resource
import com.debin.pokemonsearch.pokemoncore.utils.StateResponse
import com.debin.pokemonsearch.pokemoncore.utils.StateResponse.Loading
import kotlinx.coroutines.FlowPreview

import kotlinx.coroutines.flow.*

private const val TAG = "PokemonCoreDataSourceImpl"
class PokemonCoreDataSourceImpl(private val database : PokemonDatabase) : PokemonCoreDataSource{

    override suspend fun addPokemonToFavourites(pokemon: Pokemon) {
        return database.pfDao.addToFavourite(PokemonFavouriteEntity(id = pokemon.id, name = pokemon.name,
        description = pokemon.description, imageUrl = pokemon.imageUrl))
    }

    @FlowPreview
    override suspend fun getFavouritePokemon(): Flow<StateResponse<List<Pokemon>>> {
        return database.pfDao.getFavouritePokemon().flatMapMerge {
            flow {
                println("$TAG :: flat merge :: $it")
                emit(StateResponse.Success(it.asDomainModel()))
            }
        }
    }

    override suspend fun removePokemonFromFavourite(pokemon: Pokemon) {
          return database.pfDao.removeFromFavourite(PokemonFavouriteEntity(
              id = pokemon.id, name = pokemon.name,
              description = pokemon.description, imageUrl = pokemon.imageUrl
          ))
    }
}