package com.debin.pokemonsearch.pokemonservice.data.mappers.pokemonSpeciesMapper

import com.debin.pokemonsearch.pokemonservice.data.mappers.EntityMapper
import com.debin.pokemonsearch.pokemonservice.data.models.pokemonSpeciesEntity.PokemonSpeciesResponseEntity
import com.debin.pokemonsearch.pokemonservice.domain.pokemonspices.PokemonSpeciesResponse

open class PokemonSpeciesResponseEntityMapper(private val flavorTextEntryEntityMapper: FlavorTextEntryEntityMapper) : EntityMapper<PokemonSpeciesResponseEntity, PokemonSpeciesResponse>()  {
    override fun mapFromRemote(type: PokemonSpeciesResponseEntity): PokemonSpeciesResponse {
        return PokemonSpeciesResponse(flavorTextEntryEntityMapper.mapFromRemote(type.flavor_text_entries), id = type.id, name = type.name)
    }
}