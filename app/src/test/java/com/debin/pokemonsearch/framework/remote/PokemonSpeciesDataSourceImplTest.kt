package com.debin.pokemonsearch.framework.remote

import com.debin.pokemonsearch.framework.network.ApiService
import com.debin.pokemonsearch.pokemonservice.domain.pokemon.PokemonResponse
import com.debin.pokemonsearch.pokemonservice.domain.pokemonspices.PokemonSpeciesResponse
import com.debin.pokemonsearch.utils.PokemonFactory
import com.nhaarman.mockito_kotlin.any
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import com.nhaarman.mockito_kotlin.whenever
import io.reactivex.Single
import org.junit.Before

import org.junit.Assert.*
import org.junit.Test

class PokemonSpeciesDataSourceImplTest {
    private lateinit var mockApiService: ApiService
    private lateinit var dataSourceImpl: PokemonSpeciesDataSourceImpl

    @Before
    fun setUp() {
        mockApiService = mock()
        dataSourceImpl = PokemonSpeciesDataSourceImpl(mockApiService)
    }

    @Test
    fun verifyGetPokemonSpeciesCalled() {
        val pokemonName = PokemonFactory.getPokemonName()
        dataSourceImpl.getPokemonSpeciesAsync(pokemonName)
        verify(mockApiService).getPokemonSpecies(pokemonName)
    }

    @Test
    fun getPokemonSpeciesRepositoryComplete_without_errors() {
        val pokemonName = PokemonFactory.getPokemonName()
        val pokemonResponse = PokemonFactory.makePokemonSpeciesResponse()
        stubWheneverThenReturn(Single.just(pokemonResponse))
        val testObserver = dataSourceImpl.getPokemonSpeciesAsync(pokemonName).toObservable().test()
        testObserver.assertComplete()
        testObserver.assertNoErrors()
        testObserver.assertNoTimeout()

    }

    @Test
    fun getPokemonSpeciesRepositoryComplete_with_errors() {
        val pokemonName = PokemonFactory.getPokemonName()
        val error = PokemonFactory.getError()
        stubWheneverThenReturn(Single.error(error))
        val testObserver = dataSourceImpl.getPokemonSpeciesAsync(pokemonName).toObservable().test()
        testObserver.assertError(error)
    }

    @Test
    fun getPokemonSpeciesRepository_returns_data() {
        val pokemonName = PokemonFactory.getPokemonName()
        val pokemonResponse = PokemonFactory.makePokemonSpeciesResponse()
        stubWheneverThenReturn(Single.just(pokemonResponse))
        val testObserver = dataSourceImpl.getPokemonSpeciesAsync(pokemonName).toObservable().test()
        testObserver.assertComplete()
        testObserver.assertNoErrors()
        testObserver.assertNoTimeout()
        testObserver.assertValue(pokemonResponse)
    }

    private fun stubWheneverThenReturn(single : Single<PokemonSpeciesResponse>) {
        whenever(mockApiService.getPokemonSpecies(any())).thenReturn(single)
    }
}