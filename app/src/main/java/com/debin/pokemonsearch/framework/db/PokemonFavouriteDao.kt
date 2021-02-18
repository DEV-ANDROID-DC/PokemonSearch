package com.debin.pokemonsearch.framework.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface PokemonFavouriteDao {

    @Insert(onConflict = REPLACE)
    fun addToFavourite(pokemon : PokemonFavouriteEntity)

    @Query("SELECT * from favourites")
    fun getFavouritePokemon() : Flow<List<PokemonFavouriteEntity>>

    @Delete
    fun removeFromFavourite(pokemon : PokemonFavouriteEntity)
}