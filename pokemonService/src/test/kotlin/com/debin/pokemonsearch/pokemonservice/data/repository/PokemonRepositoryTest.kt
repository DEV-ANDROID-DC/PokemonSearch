package com.debin.pokemonsearch.pokemonservice.data.repository

import com.debin.pokemonsearch.pokemonservice.data.datasource.IPokemonDataSource
import com.debin.pokemonsearch.pokemonservice.data.mappers.pokemonMapper.PokemonResponseEntityMapper
import com.debin.pokemonsearch.pokemonservice.data.repository.utils.PokemonFactory
import com.nhaarman.mockito_kotlin.any
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import io.reactivex.Single
import org.junit.After
import org.junit.Before

import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.Mockito


@RunWith(JUnit4::class)
class PokemonRepositoryTest {

    private lateinit var mockDataSource: IPokemonDataSource
    private lateinit var repository: PokemonRepository
    private lateinit var entityMapper: PokemonResponseEntityMapper

    @Before
    fun setUp() {
        mockDataSource = mock()
        entityMapper = mock()
        repository = PokemonRepository(mockDataSource, entityMapper)
    }

    @After
    fun tearDown() {
    }

    @Test
    fun verifyPokemonRepository_calls_getPokemonAsync() {
        val pokemonName = PokemonFactory.getPokemonName()
        val pokemonResponse = PokemonFactory.makePokemonResponseEntity()
        Mockito.`when`(mockDataSource.getPokemonAsync(pokemonName)).thenReturn(Single.just(pokemonResponse))
        val pokemon = repository.getPokemon(pokemonName)
        verify(mockDataSource).getPokemonAsync(pokemonName)
    }

    @Test
    fun getPokemonRepositoryComplete_without_errors() {
        val pokemonName = PokemonFactory.getPokemonName()
        val response = PokemonFactory.makePokemonResponse()
        val pokemonResponse = PokemonFactory.makePokemonResponseEntity()
        Mockito.`when`(mockDataSource.getPokemonAsync(pokemonName)).thenReturn(Single.just(pokemonResponse))
        Mockito.`when`(entityMapper.mapFromRemote(pokemonResponse)).thenReturn(response)
        val testObserver = repository.getPokemon(pokemonName).toObservable().test()
        testObserver.assertComplete()
        testObserver.assertNoErrors()
        testObserver.assertNoTimeout()
    }

    @Test
    fun getPokemonRepositoryComplete_with_errors() {
        val pokemonName = PokemonFactory.getPokemonName()
        val error = PokemonFactory.getError()
        Mockito.`when`(mockDataSource.getPokemonAsync(pokemonName)).thenReturn(Single.error(error))
        val testObserver = repository.getPokemon(pokemonName).toObservable().test()
        testObserver.assertError(error)
    }

    @Test
    fun getPokemonRepository_returns_data() {
        val pokemonName = PokemonFactory.getPokemonName()
        val response = PokemonFactory.makePokemonResponse()
        val pokemonResponse = PokemonFactory.makePokemonResponseEntity()
        Mockito.`when`(mockDataSource.getPokemonAsync(pokemonName)).thenReturn(Single.just(pokemonResponse))
        Mockito.`when`(entityMapper.mapFromRemote(pokemonResponse)).thenReturn(response)
        val testObserver = repository.getPokemon(pokemonName).toObservable().test()
        testObserver.assertComplete()
        testObserver.assertNoErrors()
        testObserver.assertNoTimeout()
        testObserver.assertValue(response)
    }
}