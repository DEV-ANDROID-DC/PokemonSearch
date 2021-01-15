package com.debin.pokemonsearch.di

import com.debin.pokemonsearch.framework.executor.UiThread
import com.debin.pokemonsearch.pokemonservice.domain.executor.JobExecutor
import com.debin.pokemonsearch.pokemonservice.interactors.GetPokemonDescription
import com.debin.pokemonsearch.pokemonservice.interactors.GetPokemonSprites
import org.koin.dsl.module

val useCaseModule = module {
    factory { GetPokemonDescription(get(), JobExecutor(), UiThread()) }
    factory { GetPokemonSprites(get(), JobExecutor(), UiThread()) }
}