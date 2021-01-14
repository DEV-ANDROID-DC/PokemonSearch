package com.debin.pokemonsearch.pokemonservice.suite

import com.debin.pokemonsearch.pokemonservice.data.repository.PokemonRepositoryTest
import com.debin.pokemonsearch.pokemonservice.data.repository.PokemonSpeciesRepositoryTest
import com.debin.pokemonsearch.pokemonservice.interactors.GetPokemonDescriptionTest
import com.debin.pokemonsearch.pokemonservice.interactors.GetPokemonSpritesTest
import org.junit.runner.RunWith
import org.junit.runners.Suite


@RunWith(Suite::class)
@Suite.SuiteClasses(
    GetPokemonSpritesTest::class,
    GetPokemonDescriptionTest::class,
    PokemonRepositoryTest::class,
    PokemonSpeciesRepositoryTest::class
)
class PokemonSuite