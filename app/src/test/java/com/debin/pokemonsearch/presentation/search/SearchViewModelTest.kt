package com.debin.pokemonsearch.presentation.search

import android.content.Context
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MediatorLiveData
import com.debin.pokemonsearch.pokemoncore.interactors.AddToFavourites
import com.debin.pokemonsearch.presentation.utils.Resource
import com.debin.pokemonsearch.pokemonservice.domain.pokemon.PokemonResponse
import com.debin.pokemonsearch.pokemonservice.domain.pokemonspices.PokemonSpeciesResponse
import com.debin.pokemonsearch.pokemonservice.interactors.GetPokemonDescription
import com.debin.pokemonsearch.pokemonservice.interactors.GetPokemonSprites
import com.debin.pokemonsearch.utils.PokemonFactory
import com.nhaarman.mockito_kotlin.any
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.whenever
import io.reactivex.Single
import org.junit.Before
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.InjectMocks

@RunWith(JUnit4::class)
class SearchViewModelTest {

    private lateinit var viewModel: SearchViewModel
    private lateinit var getPokemonDescription: GetPokemonDescription
    private lateinit var getPokemonSprites: GetPokemonSprites
    private lateinit var addToFavourites: AddToFavourites


    @get:Rule
    val rule = InstantTaskExecutorRule()

    @Before
    fun setUp() {
        getPokemonDescription = mock()
        getPokemonSprites = mock()
        addToFavourites = mock()
        viewModel = SearchViewModel(getPokemonDescription, getPokemonSprites, addToFavourites)
    }

    @Test
    fun test_loading_is_emited_for_pokemon() {
        val pokemonName = PokemonFactory.getPokemonName()
        val pokemonResponse = PokemonFactory.makePokemonResponse()
        stubWheneverThenReturn(Single.just(pokemonResponse))
        viewModel.getPokemonDetails(pokemonName)
        val mediatorLiveData = MediatorLiveData<Resource<PokemonResponse>>()
        mediatorLiveData.addSource(viewModel.pokemon) { result ->
            assertTrue(result is Resource.Loading)
        }
    }

    @Test
    fun test_error_is_emited_for_pokemon() {
        val pokemonName = PokemonFactory.getPokemonName()
        val error = PokemonFactory.getError()
        stubWheneverThenReturn(Single.error(error))
        viewModel.getPokemonDetails(pokemonName)
        val mediatorLiveData = MediatorLiveData<Resource<PokemonResponse>>()
        mediatorLiveData.addSource(viewModel.pokemon) { result ->
            assertTrue(result is Resource.Error)
        }
    }

    @Test
    fun test_data_is_emited_for_pokemon() {
        val pokemonName = PokemonFactory.getPokemonName()
        val pokemonResponse = PokemonFactory.makePokemonResponse()
        stubWheneverThenReturn(Single.just(pokemonResponse))
        viewModel.getPokemonDetails(pokemonName)
        val mediatorLiveData = MediatorLiveData<Resource<PokemonResponse>>()
        mediatorLiveData.addSource(viewModel.pokemon) { result ->
            assertTrue(result is Resource.Success)
        }
    }

    @Test
    fun test_data_emitted_is_sprites() {
        val pokemonName = PokemonFactory.getPokemonName()
        val pokemonResponse = PokemonFactory.makePokemonResponse()
        stubWheneverThenReturn(Single.just(pokemonResponse))
        viewModel.getPokemonDetails(pokemonName)
        val mediatorLiveData = MediatorLiveData<Resource<PokemonResponse>>()
        mediatorLiveData.addSource(viewModel.pokemon) { result ->
            when (result) {
                is Resource.Success -> {
                    assertEquals(pokemonResponse.sprites, result.result.sprites)
                }
            }
        }
    }

    @Test
    fun test_loading_is_emited_for_pokemon_species() {
        val pokemonName = PokemonFactory.getPokemonName()
        val pokemonResponse = PokemonFactory.makePokemonSpeciesResponse()
        stubWheneverSpeciesThenReturn(Single.just(pokemonResponse))
        viewModel.getPokemonSpeciesDetails(pokemonName)
        val mediatorLiveData = MediatorLiveData<Resource<PokemonSpeciesResponse>>()
        mediatorLiveData.addSource(viewModel.pokemonSpecies) { result ->
            assertTrue(result is Resource.Loading)
        }
    }

    @Test
    fun test_error_is_emited_for_pokemon_species() {
        val pokemonName = PokemonFactory.getPokemonName()
        val error = PokemonFactory.getError()
        stubWheneverThenReturn(Single.error(error))
        viewModel.getPokemonSpeciesDetails(pokemonName)
        val mediatorLiveData = MediatorLiveData<Resource<PokemonSpeciesResponse>>()
        mediatorLiveData.addSource(viewModel.pokemonSpecies) { result ->
            assertTrue(result is Resource.Error)
        }
    }

    @Test
    fun test_data_is_emited_for_pokemon_species() {
        val pokemonName = PokemonFactory.getPokemonName()
        val pokemonResponse = PokemonFactory.makePokemonSpeciesResponse()
        stubWheneverSpeciesThenReturn(Single.just(pokemonResponse))
        viewModel.getPokemonSpeciesDetails(pokemonName)
        val mediatorLiveData = MediatorLiveData<Resource<PokemonSpeciesResponse>>()
        mediatorLiveData.addSource(viewModel.pokemonSpecies) { result ->
            assertTrue(result is Resource.Success)
        }
    }

    @Test
    fun test_data_emited_is_list_of_FlavorTextEntry() {
        val pokemonName = PokemonFactory.getPokemonName()
        val pokemonResponse = PokemonFactory.makePokemonSpeciesResponse()
        stubWheneverSpeciesThenReturn(Single.just(pokemonResponse))
        viewModel.getPokemonSpeciesDetails(pokemonName)
        val mediatorLiveData = MediatorLiveData<Resource<PokemonSpeciesResponse>>()
        mediatorLiveData.addSource(viewModel.pokemonSpecies) { result ->
            when (result) {
                is Resource.Success -> {
                    assertEquals(
                        pokemonResponse.flavor_text_entries,
                        result.result.flavor_text_entries
                    )
                }
            }
        }
    }

    private fun stubWheneverThenReturn(single: Single<PokemonResponse>) {
        whenever(getPokemonSprites.buildUseCaseObservable(any(), any())).thenReturn(single)
    }

    private fun stubWheneverSpeciesThenReturn(single: Single<PokemonSpeciesResponse>) {
        whenever(getPokemonDescription.buildUseCaseObservable(any(), any())).thenReturn(single)
    }
}