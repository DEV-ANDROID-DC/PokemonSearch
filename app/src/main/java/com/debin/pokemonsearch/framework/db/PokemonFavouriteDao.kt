package com.debin.pokemonsearch.framework.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query

@Dao
interface PokemonFavouriteDao {

    @Insert(onConflict = REPLACE)
    suspend fun addToFavourite(pokemon : PokemonFavouriteEntity)

    @Query("SELECT * from favourites")
    suspend fun getFavouritePokemon() : List<PokemonFavouriteEntity>

    @Delete
    suspend fun removeFromFavourite(pokemon : PokemonFavouriteEntity)
}