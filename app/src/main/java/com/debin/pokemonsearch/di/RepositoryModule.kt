package com.debin.pokemonsearch.di

import com.debin.pokemonsearch.pokemonservice.data.repository.PokemonRepository
import com.debin.pokemonsearch.pokemonservice.data.repository.PokemonSpeciesRepository
import com.debin.pokemonsearch.pokemonservice.domain.repository.IPokemonRepository
import com.debin.pokemonsearch.pokemonservice.domain.repository.IPokemonSpeciesRepository
import org.koin.dsl.module

val repositoryModule = module {
    single<IPokemonRepository> { PokemonRepository(get(), get()) }
    single<IPokemonSpeciesRepository> { PokemonSpeciesRepository(get()) }
}