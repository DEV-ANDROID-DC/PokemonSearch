package com.debin.pokemonsearch.pokemonservice.data.repository

import com.debin.pokemonsearch.pokemonservice.data.datasource.IPokemonDataSource
import com.debin.pokemonsearch.pokemonservice.data.mappers.pokemonMapper.PokemonResponseEntityMapper
import com.debin.pokemonsearch.pokemonservice.domain.pokemon.PokemonResponse
import com.debin.pokemonsearch.pokemonservice.domain.repository.IPokemonRepository
import io.reactivex.Single

class PokemonRepository(private val dataSource: IPokemonDataSource,
                        private val pokemonResponseEntityMapper: PokemonResponseEntityMapper
) : IPokemonRepository {
    override fun getPokemon(name: String?): Single<PokemonResponse> {
       return dataSource.getPokemonAsync(name).map {
           pokemonResponseEntityMapper.mapFromRemote(it)
       }
    }
}