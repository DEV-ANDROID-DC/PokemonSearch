package com.debin.pokemonsearch.framework.utils

const val BASE_URL = "https://pokeapi.co/"
private const val VERSION = "api/v2/"
const val POKEMON_NAME = "pokemon"
private const val POKEMON_SPECIES = "pokemon-species/"
private const val POKEMON = "pokemon/"
const val GET_POKEMON_SPECIES = "$VERSION$POKEMON_SPECIES{$POKEMON_NAME}"
const val GET_POKEMON = "$VERSION$POKEMON{$POKEMON_NAME}"