package com.debin.pokemonsearch.pokemoncore.data.mappers

abstract class EntityMapper<in E, out M> {
    abstract fun mapFromCore(type : E) : M
}