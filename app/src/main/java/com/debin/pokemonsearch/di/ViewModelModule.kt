package com.debin.pokemonsearch.di

import com.debin.pokemonsearch.presentation.favourites.FavouriteViewModel
import com.debin.pokemonsearch.presentation.search.SearchViewModel
import org.koin.android.viewmodel.dsl.viewModel

import org.koin.dsl.module

val viewModelModule = module {
    viewModel { SearchViewModel(get(), get(), get()) }
    viewModel { FavouriteViewModel(get(), get()) }
}