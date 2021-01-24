package com.debin.pokemonsearch.pokemonservice.data.mappers.pokemonSpeciesMapper

import com.debin.pokemonsearch.pokemonservice.data.mappers.EntityMapper
import com.debin.pokemonsearch.pokemonservice.data.models.pokemonSpeciesEntity.FlavorTextEntryEntity
import com.debin.pokemonsearch.pokemonservice.domain.pokemonspices.FlavorTextEntry

class FlavorTextEntryEntityMapper : EntityMapper<FlavorTextEntryEntity, FlavorTextEntry>(){
    override fun mapFromRemote(type: FlavorTextEntryEntity): FlavorTextEntry {
        return FlavorTextEntry(flavor_text = type.flavor_text)
    }

}