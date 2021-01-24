package com.debin.pokemonsearch.framework.remote

import com.debin.pokemonsearch.framework.network.ApiService
import com.debin.pokemonsearch.pokemonservice.data.models.pokemonEntity.PokemonResponseEntity
import com.debin.pokemonsearch.pokemonservice.domain.pokemon.PokemonResponse
import com.debin.pokemonsearch.utils.PokemonFactory
import com.nhaarman.mockito_kotlin.any
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import com.nhaarman.mockito_kotlin.whenever
import io.reactivex.Single
import org.junit.After
import org.junit.Before

import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class PokemonDataSourceImplTest {

    private lateinit var mockApiService: ApiService
    private lateinit var dataSourceImpl: PokemonDataSourceImpl

    @Before
    fun setUp() {
        mockApiService = mock()
        dataSourceImpl = PokemonDataSourceImpl(mockApiService)
    }

    @Test
    fun verifyGetPokemonCalled() {
        val pokemonName = PokemonFactory.getPokemonName()
        dataSourceImpl.getPokemonAsync(pokemonName)
        verify(mockApiService).getPokemon(pokemonName)
    }

    @Test
    fun getPokemonRepositoryComplete_without_errors() {
        val pokemonName = PokemonFactory.getPokemonName()
        val pokemonResponse = PokemonFactory.makePokemonResponseEntity()
        stubWheneverThenReturn(Single.just(pokemonResponse))
        val testObserver = dataSourceImpl.getPokemonAsync(pokemonName).toObservable().test()
        testObserver.assertComplete()
        testObserver.assertNoErrors()
        testObserver.assertNoTimeout()

    }

    @Test
    fun getPokemonRepositoryComplete_with_errors() {
        val pokemonName = PokemonFactory.getPokemonName()
        val error = PokemonFactory.getError()
        stubWheneverThenReturn(Single.error(error))
        val testObserver = dataSourceImpl.getPokemonAsync(pokemonName).toObservable().test()
        testObserver.assertError(error)
    }

    @Test
    fun getPokemonRepository_returns_data() {
        val pokemonName = PokemonFactory.getPokemonName()
        val pokemonResponse = PokemonFactory.makePokemonResponseEntity()
        stubWheneverThenReturn(Single.just(pokemonResponse))
        val testObserver = dataSourceImpl.getPokemonAsync(pokemonName).toObservable().test()
        testObserver.assertComplete()
        testObserver.assertNoErrors()
        testObserver.assertNoTimeout()
        testObserver.assertValue(pokemonResponse)
    }

    private fun stubWheneverThenReturn(single : Single<PokemonResponseEntity>) {
        whenever(mockApiService.getPokemon(any())).thenReturn(single)
    }

}