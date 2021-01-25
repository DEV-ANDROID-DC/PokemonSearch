package com.debin.pokemonsearch.presentation.favourites

import androidx.lifecycle.ViewModel
import com.debin.pokemonsearch.pokemoncore.interactors.GetFavourites
import com.debin.pokemonsearch.pokemoncore.interactors.RemoveFromFavourite

class FavouriteViewModel(private val getFavourites: GetFavourites,
                         private val removeFromFavourite: RemoveFromFavourite) : ViewModel() {
}