package com.debin.pokemonsearch.di

import com.debin.pokemonsearch.pokemonservice.data.mappers.pokemonMapper.PokemonResponseEntityMapper
import com.debin.pokemonsearch.pokemonservice.data.mappers.pokemonMapper.SpritesEntityMapper
import org.koin.dsl.module

val mapperModule = module {
   single { SpritesEntityMapper() }
   single { PokemonResponseEntityMapper(get()) }
}