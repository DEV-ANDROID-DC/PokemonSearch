package com.debin.pokemonsearch.di

import com.debin.pokemonsearch.framework.db.PokemonDatabaseFactory
import org.koin.dsl.module

val databaseModule = module {
   single { PokemonDatabaseFactory.getDBInstance(get()) }
}