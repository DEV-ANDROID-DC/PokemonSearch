package com.debin.pokemonsearch.framework.db

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [PokemonFavouriteEntity::class], version = 1, exportSchema = false)
abstract class PokemonDatabase : RoomDatabase() {
    abstract val pfDao : PokemonFavouriteDao
}