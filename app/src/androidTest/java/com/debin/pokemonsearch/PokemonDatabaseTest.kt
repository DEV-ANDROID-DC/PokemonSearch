package com.debin.pokemonsearch

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry

import com.debin.pokemonsearch.framework.db.PokemonDatabase
import com.debin.pokemonsearch.framework.db.PokemonFavouriteDao
import com.debin.pokemonsearch.utils.DataFactory
import junit.framework.Assert.assertEquals
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.asExecutor
import kotlinx.coroutines.async
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.TestCoroutineScope
import kotlinx.coroutines.test.runBlockingTest
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@ExperimentalCoroutinesApi
@RunWith(AndroidJUnit4::class)
class PokemonDatabaseTest {

    private lateinit var pokemonDao : PokemonFavouriteDao
    private lateinit var db : PokemonDatabase


    val testDispatcher = TestCoroutineDispatcher()
    val testScope = TestCoroutineScope(testDispatcher)


    @Before
    fun setUp() {

      db = Room
          .inMemoryDatabaseBuilder(InstrumentationRegistry.getInstrumentation().context, PokemonDatabase::class.java)
          .setTransactionExecutor(testDispatcher.asExecutor())
          .setQueryExecutor(testDispatcher.asExecutor()).build()
        pokemonDao = db.pfDao
    }

    @Test
    fun storeFavouritePokemon()   = testScope.runBlockingTest {
        val pokemon = DataFactory.makePokemon()
        val result = async {
            pokemonDao.getFavouritePokemon()
        }
       assertThat(result, null)
    }

    @Test
    fun storeFavouritePokemonTest()   = testScope.runBlockingTest {
        val pokemon = DataFactory.makePokemon()
        pokemonDao.addToFavourite(pokemon)
        val result = async {
            pokemonDao.getFavouritePokemon()
        }
        assertEquals(result, pokemon)
    }
}