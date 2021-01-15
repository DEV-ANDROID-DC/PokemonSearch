package com.debin.pokemonsearch

import android.app.Application
import com.debin.pokemonsearch.di.apiModule
import com.debin.pokemonsearch.di.dataSourceModule
import com.debin.pokemonsearch.di.repositoryModule
import com.debin.pokemonsearch.di.useCaseModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class PokemonApp : Application(){
    val modules = listOf(apiModule, dataSourceModule, repositoryModule, useCaseModule)
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(applicationContext)
            modules(modules)
        }
    }
}