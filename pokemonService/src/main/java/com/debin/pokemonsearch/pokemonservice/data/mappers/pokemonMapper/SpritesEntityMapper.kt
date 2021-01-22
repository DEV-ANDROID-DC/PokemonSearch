package com.debin.pokemonsearch.pokemonservice.data.mappers.pokemonMapper

import com.debin.pokemonsearch.pokemonservice.data.mappers.EntityMapper
import com.debin.pokemonsearch.pokemonservice.data.models.pokemonEntity.SpritesEntity
import com.debin.pokemonsearch.pokemonservice.domain.pokemon.Sprites

class SpritesEntityMapper : EntityMapper<SpritesEntity, Sprites>() {
    override fun mapFromRemote(spritesEntity: SpritesEntity): Sprites {
        return Sprites(back_shiny_female = spritesEntity.back_shiny_female, back_shiny = spritesEntity.back_shiny, front_shiny = spritesEntity.front_shiny,
                       front_female = spritesEntity.front_female, front_default = spritesEntity.front_default, back_female = spritesEntity.back_female,
                       back_default = spritesEntity.back_default, front_shiny_female = spritesEntity.front_shiny_female)
    }
}