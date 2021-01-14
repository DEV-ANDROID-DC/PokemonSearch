package com.debin.pokemonsearch.pokemonservice.data.repository

import com.debin.pokemonsearch.pokemonservice.data.datasource.IPokemonSpeciesDataSource
import com.debin.pokemonsearch.pokemonservice.data.repository.utils.PokemonFactory
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import io.reactivex.Single
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.Mockito

@RunWith(JUnit4::class)
class PokemonSpeciesRepositoryTest  {

    private lateinit var mockDataSource: IPokemonSpeciesDataSource
    private lateinit var repository: PokemonSpeciesRepository

    @Before
    fun setUp() {
        mockDataSource = mock()
        repository = PokemonSpeciesRepository(mockDataSource)
    }

    @Test
    fun verifyPokemonRepository_calls_getPokemonAsync() {
        val pokemonName = PokemonFactory.getPokemonName()
        val pokemon = repository.getPokemonSpecies(pokemonName)
        verify(mockDataSource).getPokemonSpeciesAsync(pokemonName)
    }

    @Test
    fun getPokemonRepositoryComplete_without_errors() {
        val pokemonName = PokemonFactory.getPokemonName()
        val pokemonResponse = PokemonFactory.makePokemonSpeciesResponse()
        Mockito.`when`(mockDataSource.getPokemonSpeciesAsync(pokemonName)).thenReturn(Single.just(pokemonResponse))
        val testObserver = repository.getPokemonSpecies(pokemonName).toObservable().test()
        testObserver.assertComplete()
        testObserver.assertNoErrors()
        testObserver.assertNoTimeout()
    }

    @Test
    fun getPokemonRepositoryComplete_with_errors() {
        val pokemonName = PokemonFactory.getPokemonName()
        val error = PokemonFactory.getError()
        Mockito.`when`(mockDataSource.getPokemonSpeciesAsync(pokemonName)).thenReturn(Single.error(error))
    }

    @Test
    fun getPokemonRepository_returns_data() {
        val pokemonName = PokemonFactory.getPokemonName()
        val pokemonResponse = PokemonFactory.makePokemonSpeciesResponse()
        Mockito.`when`(mockDataSource.getPokemonSpeciesAsync(pokemonName)).thenReturn(Single.just(pokemonResponse))
        val testObserver = repository.getPokemonSpecies(pokemonName).toObservable().test()
        testObserver.assertComplete()
        testObserver.assertNoErrors()
        testObserver.assertNoTimeout()
        testObserver.assertValue(pokemonResponse)
    }
}