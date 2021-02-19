package com.debin.pokemonsearch.utils

import com.debin.pokemonsearch.framework.db.PokemonFavouriteEntity
import com.debin.pokemonsearch.pokemoncore.data.model.PokemonCoreEntity
import com.debin.pokemonsearch.pokemoncore.domain.repository.Pokemon

class DataFactory {

    companion object Factory {

        fun makePokemon() : PokemonFavouriteEntity {
            val pokemonEntity = PokemonFavouriteEntity(1, "butterfree", "In battle, it flaps its wings at high speed to" +
                    "frelease highly toxic dust into the air.","https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/12.png")
            return pokemonEntity
        }
    }

}