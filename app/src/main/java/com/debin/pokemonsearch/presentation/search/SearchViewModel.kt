package com.debin.pokemonsearch.presentation.search

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.debin.pokemonsearch.framework.utils.Resource
import com.debin.pokemonsearch.pokemonservice.domain.pokemon.PokemonResponse
import com.debin.pokemonsearch.pokemonservice.domain.pokemonspices.PokemonSpeciesResponse
import com.debin.pokemonsearch.pokemonservice.interactors.GetPokemonDescription
import com.debin.pokemonsearch.pokemonservice.interactors.GetPokemonSprites
import io.reactivex.observers.DisposableSingleObserver


open class SearchViewModel(private val getPokemonDescription: GetPokemonDescription,
                      private val getPokemonSprites: GetPokemonSprites) : ViewModel() {
    val pokemonDescription = MutableLiveData<String>()
    val pokemon = MutableLiveData<Resource<PokemonResponse>>()
    val pokemonSpecies = MutableLiveData<Resource<PokemonSpeciesResponse>>()

    init {
        pokemon.value = Resource.Loading()
        pokemonSpecies.value = Resource.Loading()
    }

    fun getPokemonDetails(pokemonName : String) {
        getPokemonSprites.execute(PokemonSubscriber(), pokemonName)
    }

    fun getPokemonSpeciesDetails(pokemonName : String) {
        getPokemonDescription.execute(PokemonSpeciesSubscriber(), pokemonName)
    }

    inner class PokemonSubscriber : DisposableSingleObserver<PokemonResponse>() {
        override fun onSuccess(pokemonResponse: PokemonResponse) {
            pokemon.value = Resource.Success(pokemonResponse)
        }

        override fun onError(error: Throwable) {
            pokemon.value = Resource.Error(error.message)
        }
    }

    inner class PokemonSpeciesSubscriber : DisposableSingleObserver<PokemonSpeciesResponse>() {
        override fun onSuccess(pokemonSpeciesResponse: PokemonSpeciesResponse) {
           pokemonSpecies.value = Resource.Success(pokemonSpeciesResponse)
        }

        override fun onError(error: Throwable) {
            pokemonSpecies.value = Resource.Error(error.message)
        }
    }

    override fun onCleared() {
        super.onCleared()
        getPokemonDescription.dispose()
        getPokemonSprites.dispose()
    }
}