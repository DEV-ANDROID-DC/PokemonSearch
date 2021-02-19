package com.debin.pokemonsearch.pokemoncore.data.mappers

import com.debin.pokemonsearch.pokemoncore.data.model.PokemonCoreEntity
import com.debin.pokemonsearch.pokemoncore.domain.repository.Pokemon

class PokemonCoreEntityMapper(private val pokemonEntityMapper: PokemonEntityMapper) : EntityMapper<List<PokemonCoreEntity>, List<Pokemon>>() {
    override fun mapFromCore(type: List<PokemonCoreEntity>): List<Pokemon> {
        return pokemonEntityMapper.mapFromCoreList(type)
    }
}