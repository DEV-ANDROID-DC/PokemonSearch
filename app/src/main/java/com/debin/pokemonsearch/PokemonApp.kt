package com.debin.pokemonsearch

import android.app.Application
import com.debin.pokemonsearch.di.*
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class PokemonApp : Application(){
    private val modules = listOf(apiModule, dataSourceModule, mapperModule, repositoryModule, useCaseModule, viewModelModule)
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(applicationContext)
            modules(modules)
        }
    }
}