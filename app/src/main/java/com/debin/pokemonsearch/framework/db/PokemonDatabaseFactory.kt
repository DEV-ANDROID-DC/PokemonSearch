package com.debin.pokemonsearch.framework.db

import android.content.Context
import androidx.room.Room

object PokemonDatabaseFactory {

    fun getDBInstance(context: Context) {
        Room.databaseBuilder(context, PokemonDatabase::class.java, "PokemonDB")
            .fallbackToDestructiveMigration()
            .build()
    }
}