package com.debin.pokemonsearch.presentation.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.debin.pokemonsearch.pokemoncore.domain.repository.Pokemon
import com.debin.pokemonsearch.pokemoncore.interactors.AddToFavourites
import com.debin.pokemonsearch.presentation.utils.Resource
import com.debin.pokemonsearch.pokemonservice.domain.pokemon.PokemonResponse
import com.debin.pokemonsearch.pokemonservice.domain.pokemonspices.PokemonSpeciesResponse
import com.debin.pokemonsearch.pokemonservice.interactors.GetPokemonDescription
import com.debin.pokemonsearch.pokemonservice.interactors.GetPokemonSprites
import io.reactivex.observers.DisposableSingleObserver
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class SearchViewModel (private val getPokemonDescription: GetPokemonDescription,
                      private val getPokemonSprites: GetPokemonSprites,
                      private val addToFavourites: AddToFavourites) : ViewModel() {

    private val _pokemon = MutableLiveData<Resource<PokemonResponse>>()
    private val _pokemonSprites = MutableLiveData<Resource<List<String>>>()
    private val _pokemonSpecies = MutableLiveData<Resource<PokemonSpeciesResponse>>()
    val pokemon : LiveData<Resource<PokemonResponse>> get() = _pokemon
    val pokemonSpecies : LiveData<Resource<PokemonSpeciesResponse>> get() = _pokemonSpecies


    fun getPokemonDetails(pokemonName : String) {
        _pokemon.value = Resource.Loading()
        getPokemonSprites.execute(PokemonSubscriber(), pokemonName)
    }

    fun getPokemonSpeciesDetails(pokemonName : String) {
        _pokemonSpecies.value = Resource.Loading()
        getPokemonDescription.execute(PokemonSpeciesSubscriber(), pokemonName)
    }

    fun addToFavourite() {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
               addToFavourites.invokeAddToFavourites(getPokemonDetails())
            }
        }
    }

    inner class PokemonSubscriber : DisposableSingleObserver<PokemonResponse>() {
        override fun onSuccess(pokemonResponse: PokemonResponse) {
            _pokemon.value = Resource.Success(pokemonResponse)
        }

        override fun onError(error: Throwable) {
            _pokemon.value = Resource.Error(error.message)
        }
    }

    inner class PokemonSpeciesSubscriber : DisposableSingleObserver<PokemonSpeciesResponse>() {
        override fun onSuccess(pokemonSpeciesResponse: PokemonSpeciesResponse) {
           _pokemonSpecies.value = Resource.Success(pokemonSpeciesResponse)
        }

        override fun onError(error: Throwable) {
            _pokemonSpecies.value = Resource.Error(error.message)
        }
    }

    private fun getPokemonDetails() : Pokemon {
         var pokemonId = 0
         var pokemonName = ""
         var pokemonDescription = ""
         var pokemonImage = ""
        _pokemon.observeForever {
            when(it) {
                is Resource.Success -> {
                    pokemonImage = it.result.sprites.front_default
                }
                else -> {

                }
            }
        }
        _pokemonSpecies.observeForever {
            when(it) {
                is Resource.Success -> {
                    pokemonId = it.result.id
                    pokemonName = it.result.name
                    pokemonDescription = it.result.flavor_text_entries[0].flavor_text
                }
                else -> {

                }
            }
        }

        return Pokemon(pokemonId, pokemonName, pokemonDescription, pokemonImage)
    }


    override fun onCleared() {
        super.onCleared()
        getPokemonDescription.dispose()
        getPokemonSprites.dispose()
    }
}