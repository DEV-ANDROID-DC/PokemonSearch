package com.debin.pokemonsearch.presentation.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.debin.pokemonsearch.presentation.utils.Resource
import com.debin.pokemonsearch.pokemonservice.domain.pokemon.PokemonResponse
import com.debin.pokemonsearch.pokemonservice.domain.pokemonspices.PokemonSpeciesResponse
import com.debin.pokemonsearch.pokemonservice.interactors.GetPokemonDescription
import com.debin.pokemonsearch.pokemonservice.interactors.GetPokemonSprites
import io.reactivex.observers.DisposableSingleObserver


class SearchViewModel(private val getPokemonDescription: GetPokemonDescription,
                      private val getPokemonSprites: GetPokemonSprites) : ViewModel() {

    private val _pokemon = MutableLiveData<Resource<PokemonResponse>>()
    private val _pokemonSprites = MutableLiveData<Resource<List<String>>>()
    private val _pokemonSpecies = MutableLiveData<Resource<PokemonSpeciesResponse>>()
    val pokemon : LiveData<Resource<PokemonResponse>> get() = _pokemon
    val pokemonSpecies : LiveData<Resource<PokemonSpeciesResponse>> get() = _pokemonSpecies
    val pokemonSprites : LiveData<Resource<List<String>>> get() = _pokemonSprites


    fun getPokemonDetails(pokemonName : String) {
        getPokemonSprites.execute(PokemonSubscriber(), pokemonName)
    }

    fun getPokemonSpeciesDetails(pokemonName : String) {
        getPokemonDescription.execute(PokemonSpeciesSubscriber(), pokemonName)
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


    override fun onCleared() {
        super.onCleared()
        getPokemonDescription.dispose()
        getPokemonSprites.dispose()
    }
}