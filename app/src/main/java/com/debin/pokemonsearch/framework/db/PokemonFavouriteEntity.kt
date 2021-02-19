package com.debin.pokemonsearch.framework.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "favourites")
data class PokemonFavouriteEntity(
    @PrimaryKey(autoGenerate = true) val id : Int,
    @ColumnInfo(name = "pokemonName") val name : String = "",
    @ColumnInfo(name = "pokemonDescription") val description : String = "",
    @ColumnInfo(name =  "pokemonImage")val imageUrl : String = ""
)