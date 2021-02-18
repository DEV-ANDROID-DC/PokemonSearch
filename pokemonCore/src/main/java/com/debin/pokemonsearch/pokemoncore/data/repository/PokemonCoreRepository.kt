package com.debin.pokemonsearch.pokemoncore.data.repository

import com.debin.pokemonsearch.pokemoncore.data.datasource.PokemonCoreDataSource
import com.debin.pokemonsearch.pokemoncore.data.mappers.PokemonCoreEntityMapper
import com.debin.pokemonsearch.pokemoncore.data.model.PokemonCoreEntity
import com.debin.pokemonsearch.pokemoncore.domain.repository.IPokemonCoreRepository
import com.debin.pokemonsearch.pokemoncore.domain.repository.Pokemon
import com.debin.pokemonsearch.pokemoncore.utils.Resource
import com.debin.pokemonsearch.pokemoncore.utils.StateResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class PokemonCoreRepository(private val dataSource: PokemonCoreDataSource) : IPokemonCoreRepository {
    override suspend fun addPokemonToFavourites(pokemon: Pokemon) {
        return dataSource.addPokemonToFavourites(pokemon)
    }

    override suspend fun getFavouritePokemon(): Flow<StateResponse<List<Pokemon>>> {
        return dataSource.getFavouritePokemon()
    }

    override suspend fun removePokemonFromFavourite(pokemon: Pokemon) {
       return dataSource.removePokemonFromFavourite(pokemon)
    }

}

//.map {
//    entityMapper.mapFromCore(it)
//}