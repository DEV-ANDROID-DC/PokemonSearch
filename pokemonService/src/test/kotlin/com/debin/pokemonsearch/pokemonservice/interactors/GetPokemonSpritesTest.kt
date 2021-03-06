package com.debin.pokemonsearch.pokemonservice.interactors

import com.debin.pokemonsearch.pokemonservice.data.repository.utils.PokemonFactory
import com.debin.pokemonsearch.pokemonservice.domain.executor.PostExecutionThread
import com.debin.pokemonsearch.pokemonservice.domain.executor.ThreadExecutor
import com.debin.pokemonsearch.pokemonservice.domain.pokemon.PokemonResponse
import com.debin.pokemonsearch.pokemonservice.domain.pokemonspices.PokemonSpeciesResponse
import com.debin.pokemonsearch.pokemonservice.domain.repository.IPokemonRepository
import com.nhaarman.mockito_kotlin.any
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import com.nhaarman.mockito_kotlin.whenever
import io.reactivex.Single
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class GetPokemonSpritesTest {

    private lateinit var getPokemonSprites: GetPokemonSprites
    private lateinit var mockThreadExecutor: ThreadExecutor
    private lateinit var mockPostExecutionThread: PostExecutionThread
    private lateinit var mockPokemonRepository: IPokemonRepository

    @Before
    fun setUp() {
        mockPokemonRepository = mock()
        mockThreadExecutor = mock()
        mockPostExecutionThread = mock()
        getPokemonSprites = GetPokemonSprites(mockPokemonRepository, mockThreadExecutor, mockPostExecutionThread)
    }

    @Test
    fun checkGetPokemonSprites_use_case_call_pokemonspecies() {
        val pokemonName = PokemonFactory.getPokemonName()
        getPokemonSprites.buildUseCaseObservable(pokemonName, null)
        verify(mockPokemonRepository).getPokemon(pokemonName)
    }

    @Test
    fun checkGetPokemonSprites_use_case_complete_without_errors() {
        val pokemonName = PokemonFactory.getPokemonName()
        val pokemonResponse = PokemonFactory.makePokemonResponse()
        stubWheneverThenReturn(Single.just(pokemonResponse))
        val testObserver = getPokemonSprites.buildUseCaseObservable(pokemonName, any()).toObservable().test()
        testObserver.assertComplete()
        testObserver.assertNoErrors()
        testObserver.assertNoTimeout()
    }

    @Test
    fun checkGetPokemonSprites_use_case_complete_with_errors() {
        val pokemonName = PokemonFactory.getPokemonName()
        val error = PokemonFactory.getError()
        stubWheneverThenReturn(Single.error(error))
        val testObserver = getPokemonSprites.buildUseCaseObservable(pokemonName, any()).toObservable().test()
        testObserver.assertError(error)
    }

    @Test
    fun checkGetPokemonSprites_use_case_returns_data() {
        val pokemonName = PokemonFactory.getPokemonName()
        val pokemonResponse = PokemonFactory.makePokemonResponse()
        stubWheneverThenReturn(Single.just(pokemonResponse))
        val testObserver = getPokemonSprites.buildUseCaseObservable(pokemonName, any()).toObservable().test()
        testObserver.assertComplete()
        testObserver.assertNoErrors()
        testObserver.assertNoTimeout()
        testObserver.assertValue(pokemonResponse)
    }

    private fun stubWheneverThenReturn(single : Single<PokemonResponse>) {
        whenever(mockPokemonRepository.getPokemon(any())).thenReturn(single)
    }

    @After
    fun tearDown() {
        getPokemonSprites.dispose()
    }
}