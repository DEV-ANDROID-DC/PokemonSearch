package com.debin.pokemonsearch.pokemonservice.interactors

import com.debin.pokemonsearch.pokemonservice.data.repository.utils.PokemonFactory
import com.debin.pokemonsearch.pokemonservice.domain.executor.PostExecutionThread
import com.debin.pokemonsearch.pokemonservice.domain.executor.ThreadExecutor
import com.debin.pokemonsearch.pokemonservice.domain.pokemonspices.PokemonSpeciesResponse
import com.debin.pokemonsearch.pokemonservice.domain.repository.IPokemonSpeciesRepository
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
class GetPokemonDescriptionTest {
    private lateinit var getPokemonDescription: GetPokemonDescription
    private lateinit var mockThreadExecutor : ThreadExecutor
    private lateinit var mockPostExecutionThread: PostExecutionThread
    private lateinit var mockSpeciesRepository: IPokemonSpeciesRepository

    @Before
    fun setUp() {
        mockThreadExecutor = mock()
        mockPostExecutionThread = mock()
        mockSpeciesRepository = mock()
        getPokemonDescription = GetPokemonDescription(mockSpeciesRepository, mockThreadExecutor, mockPostExecutionThread)
    }

    @Test
    fun checkGetPokemonDescription_use_case_call_pokemonspecies() {
         val pokemonName = PokemonFactory.getPokemonName()
         getPokemonDescription.buildUseCaseObservable(pokemonName, null)
         verify(mockSpeciesRepository).getPokemonSpecies(pokemonName)
    }

    @Test
    fun checkGetPokemonDescription_use_case_complete_without_errors() {
        val pokemonName = PokemonFactory.getPokemonName()
        val pokemonResponse = PokemonFactory.makePokemonSpeciesResponse()
        stubWheneverThenReturn(Single.just(pokemonResponse))
        val testObserver = getPokemonDescription.buildUseCaseObservable(pokemonName, any()).toObservable().test()
        testObserver.assertComplete()
        testObserver.assertNoErrors()
        testObserver.assertNoTimeout()
    }

    @Test
    fun checkGetPokemonDescription_use_case_complete_with_errors() {
        val pokemonName = PokemonFactory.getPokemonName()
        val error = PokemonFactory.getError()
        stubWheneverThenReturn(Single.error(error))
        val testObserver = getPokemonDescription.buildUseCaseObservable(pokemonName, any()).toObservable().test()
        testObserver.assertError(error)
    }

    @Test
    fun checkGetPokemonDescription_use_case_returns_data() {
        val pokemonName = PokemonFactory.getPokemonName()
        val pokemonResponse = PokemonFactory.makePokemonSpeciesResponse()
        stubWheneverThenReturn(Single.just(pokemonResponse))
        val testObserver = getPokemonDescription.buildUseCaseObservable(pokemonName, any()).toObservable().test()
        testObserver.assertComplete()
        testObserver.assertNoErrors()
        testObserver.assertNoTimeout()
        testObserver.assertValue(pokemonResponse)
    }

    private fun stubWheneverThenReturn(single : Single<PokemonSpeciesResponse>) {
        whenever(mockSpeciesRepository.getPokemonSpecies(any())).thenReturn(single)
    }

    @After
    fun tearDown() {
        getPokemonDescription.dispose()
    }
}