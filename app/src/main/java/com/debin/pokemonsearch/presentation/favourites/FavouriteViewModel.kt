package com.debin.pokemonsearch.presentation.favourites

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.debin.pokemonsearch.framework.db.PokemonFavouriteEntity
import com.debin.pokemonsearch.pokemoncore.domain.repository.Pokemon
import com.debin.pokemonsearch.pokemoncore.interactors.GetFavourites
import com.debin.pokemonsearch.pokemoncore.interactors.RemoveFromFavourite
import com.debin.pokemonsearch.pokemoncore.utils.StateResponse
import com.debin.pokemonsearch.presentation.mapper.asDomainModel
import com.debin.pokemonsearch.presentation.utils.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
private const val TAG = "FavouriteViewModel"
class FavouriteViewModel(private val getFavourites: GetFavourites,
                         private val removeFromFavourite: RemoveFromFavourite) : ViewModel() {

    private val _favourites = MutableLiveData<StateResponse<List<PokemonFavouriteEntity>>>()
    val favourites : LiveData<StateResponse<List<PokemonFavouriteEntity>>> get() = _favourites


    fun getFavouritesPokemons() {
        viewModelScope.launch {
            withContext(Dispatchers.Main) {
                getFavourite()
            }
        }
    }


    private suspend fun getFavourite() {
        getFavourites.invokeGetFavourites().collect {favourites ->
            when(favourites) {
                 is StateResponse.Loading -> {
                 _favourites.value = StateResponse.loading()
                 }
                is StateResponse.Success -> {
                    val response = favourites.data.asDomainModel()
                    println("$TAG :: Data from database :: $response")
                    _favourites.value = StateResponse.success(response)
                }
                is StateResponse.Failed -> {
                    _favourites.value = StateResponse.Failed("Error Occurred")
                }
            }
        }
    }
}

