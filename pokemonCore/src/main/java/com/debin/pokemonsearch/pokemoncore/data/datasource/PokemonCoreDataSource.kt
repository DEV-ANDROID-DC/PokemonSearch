package com.debin.pokemonsearch.pokemoncore.data.datasource

import com.debin.pokemonsearch.pokemoncore.domain.repository.Pokemon

interface PokemonCoreDataSource {
    suspend fun addPokemonToFavourites(pokemon: Pokemon)
    suspend fun getFavouritePokemon() : List<Pokemon>
    suspend fun removePokemonFromFavourite(pokemon: Pokemon)
}