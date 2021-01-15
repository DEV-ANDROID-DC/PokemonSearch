package com.debin.pokemonsearch.utils

import com.debin.pokemonsearch.pokemonservice.domain.executor.PostExecutionThread
import com.debin.pokemonsearch.pokemonservice.domain.pokemon.PokemonResponse
import com.debin.pokemonsearch.pokemonservice.domain.pokemon.Sprites
import com.debin.pokemonsearch.pokemonservice.domain.pokemonspices.FlavorTextEntry
import com.debin.pokemonsearch.pokemonservice.domain.pokemonspices.PokemonSpeciesResponse

class PokemonFactory {
    companion object Factory {

        fun makePokemonResponse(): PokemonResponse {
            return PokemonResponse(sprites())
        }

        fun makePokemonSpeciesResponse() : PokemonSpeciesResponse {
           return PokemonSpeciesResponse(listOf(flavorTextEntry()), 1, getPokemonName())
        }

        private fun sprites(): Sprites {
            return Sprites(
                "http://pokeapi.co/media/sprites/pokemon/back/female/12.png",
                "http://pokeapi.co/media/sprites/pokemon/back/shiny/female/12.png",
                "http://pokeapi.co/media/sprites/pokemon/back/12.png",
                "http://pokeapi.co/media/sprites/pokemon/female/12.png",
                "http://pokeapi.co/media/sprites/pokemon/shiny/female/12.png",
                "http://pokeapi.co/media/sprites/pokemon/back/shiny/12.png",
                "http://pokeapi.co/media/sprites/pokemon/12.png",
                "http://pokeapi.co/media/sprites/pokemon/shiny/12.png"
            )
        }

        private fun flavorTextEntry() : FlavorTextEntry {
           return FlavorTextEntry("When the bulb on\\nits back grows\\nlarge, it appears\\fto lose the\\nability to stand\\non its hind legs.")
        }

        fun getPokemonName(): String {
            val nameList = listOf<String>("pikachu", "eevee", "snorlax", "charizard", "butterfree", "ditto")
            return nameList.random()
        }

        fun getError() : Throwable {
            return Throwable()
        }
    }
}

