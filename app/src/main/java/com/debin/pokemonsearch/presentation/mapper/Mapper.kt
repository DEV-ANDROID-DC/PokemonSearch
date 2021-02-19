package com.debin.pokemonsearch.presentation.mapper

import com.debin.pokemonsearch.framework.db.PokemonFavouriteEntity
import com.debin.pokemonsearch.pokemoncore.domain.repository.Pokemon

fun List<Pokemon>.asDomainModel() : List<PokemonFavouriteEntity> {
    return map {
            PokemonFavouriteEntity(it.id, it.name, it.description, it.imageUrl)
    }
}