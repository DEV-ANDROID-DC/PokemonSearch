package com.debin.pokemonsearch.pokemoncore.data.mappers

import com.debin.pokemonsearch.pokemoncore.data.model.PokemonCoreEntity
import com.debin.pokemonsearch.pokemoncore.domain.repository.Pokemon

class PokemonCoreEntityMapper() : EntityMapper<PokemonCoreEntity, Pokemon>() {
    override fun mapFromCore(type: PokemonCoreEntity): Pokemon {
        return Pokemon(id = type.id, name = type.name, description = type.description, imageUrl = type.imageUrl)
    }
}