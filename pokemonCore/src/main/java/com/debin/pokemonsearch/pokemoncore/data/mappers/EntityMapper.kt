package com.debin.pokemonsearch.pokemoncore.data.mappers

abstract class EntityMapper<in E, out M> {
    abstract fun mapFromCore(type : E) : M

    fun mapFromCoreList(type: List<E>) : List<M> {
        val list = ArrayList<M>()
        type.forEach{item->
            list.add(mapFromCore(item))
        }
        return list
    }
}