package com.debin.pokemonsearch.di

import com.debin.pokemonsearch.framework.executor.UiThread
import com.debin.pokemonsearch.pokemoncore.interactors.AddToFavourites
import com.debin.pokemonsearch.pokemoncore.interactors.GetFavourites
import com.debin.pokemonsearch.pokemoncore.interactors.RemoveFromFavourite
import com.debin.pokemonsearch.pokemonservice.domain.executor.JobExecutor
import com.debin.pokemonsearch.pokemonservice.interactors.GetPokemonDescription
import com.debin.pokemonsearch.pokemonservice.interactors.GetPokemonSprites
import org.koin.dsl.module
import org.koin.ext.scope

val useCaseModule = module {
    factory { GetPokemonDescription(get(), JobExecutor(), UiThread()) }
    factory { GetPokemonSprites(get(), JobExecutor(), UiThread()) }
    factory { AddToFavourites(get()) }
    factory { GetFavourites(get()) }
    factory { RemoveFromFavourite(get()) }
}