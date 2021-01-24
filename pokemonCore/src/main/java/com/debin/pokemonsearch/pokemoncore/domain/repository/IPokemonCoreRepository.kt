package com.debin.pokemonsearch.pokemoncore.domain.repository

interface IPokemonCoreRepository {
    suspend fun addPokemonToFavourites(pokemon: Pokemon)
    suspend fun getFavouritePokemon() : List<Pokemon>
    suspend fun removePokemonFromFavourite(pokemon: Pokemon)
}