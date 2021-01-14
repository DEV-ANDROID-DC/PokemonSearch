package com.debin.pokemonsearch.pokemonservice.interactors

import com.debin.pokemonsearch.pokemonservice.domain.executor.PostExecutionThread
import com.debin.pokemonsearch.pokemonservice.domain.executor.ThreadExecutor
import com.debin.pokemonsearch.pokemonservice.domain.pokemon.PokemonResponse
import com.debin.pokemonsearch.pokemonservice.domain.repository.IPokemonRepository
import io.reactivex.Single

class GetPokemonSprites(private val pokemonRepository: IPokemonRepository,
                        threadExecutor: ThreadExecutor,
                        postExecutionThread: PostExecutionThread) : SingleUseCase<PokemonResponse, String, String>(threadExecutor, postExecutionThread) {
    public override fun buildUseCaseObservable(pokemonName: String?, arg2: String?): Single<PokemonResponse> {
       return pokemonRepository.getPokemon(pokemonName)
    }

}