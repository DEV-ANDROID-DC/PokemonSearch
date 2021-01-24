package com.debin.pokemonsearch.di

import com.debin.pokemonsearch.pokemonservice.data.mappers.pokemonMapper.PokemonResponseEntityMapper
import com.debin.pokemonsearch.pokemonservice.data.mappers.pokemonMapper.SpritesEntityMapper
import com.debin.pokemonsearch.pokemonservice.data.mappers.pokemonSpeciesMapper.FlavorTextEntryEntityMapper
import com.debin.pokemonsearch.pokemonservice.data.mappers.pokemonSpeciesMapper.PokemonSpeciesResponseEntityMapper
import org.koin.dsl.module

val mapperModule = module {
   single { SpritesEntityMapper() }
   single { PokemonResponseEntityMapper(get()) }
   single { FlavorTextEntryEntityMapper() }
   single { PokemonSpeciesResponseEntityMapper(get()) }
}