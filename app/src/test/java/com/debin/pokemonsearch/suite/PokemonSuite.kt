package com.debin.pokemonsearch.suite

import com.debin.pokemonsearch.framework.remote.PokemonDataSourceImplTest
import com.debin.pokemonsearch.framework.remote.PokemonSpeciesDataSourceImplTest
import org.junit.runner.RunWith
import org.junit.runners.Suite

@RunWith(Suite::class)
@Suite.SuiteClasses(
    PokemonDataSourceImplTest::class,
    PokemonSpeciesDataSourceImplTest::class
)
class PokemonSuite