package com.debin.pokemonsearch.pokemoncore.data.mappers

import com.debin.pokemonsearch.pokemoncore.data.model.PokemonCoreEntity
import com.debin.pokemonsearch.pokemoncore.domain.repository.Pokemon

class PokemonEntityMapper : EntityMapper<PokemonCoreEntity, Pokemon>() {
    override fun mapFromCore(type: PokemonCoreEntity): Pokemon {
        return Pokemon(type.id, type.name, type.description, type.imageUrl)
    }
}