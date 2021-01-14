package com.debin.pokemonsearch.pokemonservice.interactors

import com.debin.pokemonsearch.pokemonservice.data.repository.PokemonSpeciesRepository
import com.debin.pokemonsearch.pokemonservice.domain.executor.PostExecutionThread
import com.debin.pokemonsearch.pokemonservice.domain.executor.ThreadExecutor
import com.debin.pokemonsearch.pokemonservice.domain.pokemonspices.PokemonSpeciesResponse
import com.debin.pokemonsearch.pokemonservice.domain.repository.IPokemonSpeciesRepository
import io.reactivex.Single

class GetPokemonDescription(private val speciesRepository: IPokemonSpeciesRepository,
                            threadExecutor: ThreadExecutor,
                            postExecutionThread: PostExecutionThread) : SingleUseCase<PokemonSpeciesResponse, String, String>(threadExecutor, postExecutionThread){
    public override fun buildUseCaseObservable(
        pokemonName: String?,
        arg2: String?
    ): Single<PokemonSpeciesResponse> {
        return speciesRepository.getPokemonSpecies(pokemonName)
    }
}