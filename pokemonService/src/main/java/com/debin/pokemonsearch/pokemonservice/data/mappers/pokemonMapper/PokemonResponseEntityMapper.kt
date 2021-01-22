package com.debin.pokemonsearch.pokemonservice.data.mappers.pokemonMapper

import com.debin.pokemonsearch.pokemonservice.data.mappers.EntityMapper
import com.debin.pokemonsearch.pokemonservice.data.models.pokemonEntity.PokemonResponseEntity
import com.debin.pokemonsearch.pokemonservice.domain.pokemon.PokemonResponse

class PokemonResponseEntityMapper(private val spritesEntityMapper: SpritesEntityMapper) : EntityMapper<PokemonResponseEntity, PokemonResponse>() {
    override fun mapFromRemote(pokemonResponseEntity: PokemonResponseEntity): PokemonResponse {
        return PokemonResponse(spritesEntityMapper.mapSpritesFromRemote(pokemonResponseEntity.spritesEntity))
    }
}