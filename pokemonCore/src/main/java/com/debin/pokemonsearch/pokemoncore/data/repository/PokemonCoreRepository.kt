package com.debin.pokemonsearch.pokemoncore.data.repository

import com.debin.pokemonsearch.pokemoncore.data.datasource.PokemonCoreDataSource
import com.debin.pokemonsearch.pokemoncore.domain.repository.IPokemonCoreRepository
import com.debin.pokemonsearch.pokemoncore.domain.repository.Pokemon

class PokemonCoreRepository(private val dataSource: PokemonCoreDataSource) : IPokemonCoreRepository {
    override suspend fun addPokemonToFavourites(pokemon: Pokemon) {
        return dataSource.addPokemonToFavourites(pokemon)
    }

    override suspend fun getFavouritePokemon(): List<Pokemon> {
        return dataSource.getFavouritePokemon()
    }

    override suspend fun removePokemonFromFavourite(pokemon: Pokemon) {
       return dataSource.removePokemonFromFavourite(pokemon)
    }

}