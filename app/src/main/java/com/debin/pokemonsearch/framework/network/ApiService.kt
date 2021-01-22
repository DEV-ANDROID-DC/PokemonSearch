package com.debin.pokemonsearch.framework.network

import com.debin.pokemonsearch.framework.utils.GET_POKEMON
import com.debin.pokemonsearch.framework.utils.GET_POKEMON_SPECIES
import com.debin.pokemonsearch.framework.utils.POKEMON_NAME
import com.debin.pokemonsearch.pokemonservice.data.models.pokemonEntity.PokemonResponseEntity
import com.debin.pokemonsearch.pokemonservice.domain.pokemonspices.PokemonSpeciesResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET(GET_POKEMON)
    fun getPokemon(@Path (POKEMON_NAME) pokemonName : String?) : Single<PokemonResponseEntity>

    @GET(GET_POKEMON_SPECIES)
    fun getPokemonSpecies(@Path (POKEMON_NAME) pokemonName: String?) : Single<PokemonSpeciesResponse>
}