package com.debin.pokemonsearch.di

import androidx.room.Room
import com.debin.pokemonsearch.framework.db.PokemonDatabase
import org.koin.dsl.module

val databaseModule = module {
   single {
      Room.databaseBuilder(get(), PokemonDatabase::class.java, "PokemonDB")
         .fallbackToDestructiveMigration()
         .build()
   }
}