package com.debin.pokemonsearch.di

import com.debin.pokemonsearch.framework.core.PokemonCoreDataSourceImpl
import com.debin.pokemonsearch.framework.remote.PokemonDataSourceImpl
import com.debin.pokemonsearch.framework.remote.PokemonSpeciesDataSourceImpl
import com.debin.pokemonsearch.pokemoncore.data.datasource.PokemonCoreDataSource
import com.debin.pokemonsearch.pokemonservice.data.datasource.IPokemonDataSource
import com.debin.pokemonsearch.pokemonservice.data.datasource.IPokemonSpeciesDataSource
import org.koin.dsl.module

val dataSourceModule = module {
    single<IPokemonDataSource> { PokemonDataSourceImpl(get()) }
    single<IPokemonSpeciesDataSource> { PokemonSpeciesDataSourceImpl(get()) }
    single<PokemonCoreDataSource> { PokemonCoreDataSourceImpl(get()) }
}