package com.debin.pokemonsearch.presentation.search

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.debin.pokemonsearch.databinding.FragmentSearchBinding
import com.debin.pokemonsearch.presentation.utils.Resource
import org.koin.android.viewmodel.ext.android.viewModel

private const val TAG = "SearchFragment"
class SearchFragment : Fragment() {

    private val viewModel: SearchViewModel by viewModel()
    private lateinit var binding: FragmentSearchBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSearchBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            searchClick()
            observePokemonSpecies()
    }


    private fun observePokemon() {
        viewModel.pokemon.observe(viewLifecycleOwner, Observer { result ->
            when(result) {
                is Resource.Loading -> {

                }
                is Resource.Success -> {

                }
                is Resource.Error -> {

                }
            }
        })
    }

    private fun observePokemonSpecies() {
        viewModel.pokemonSpecies.observe(viewLifecycleOwner, Observer {result ->
          when(result) {
              is Resource.Loading -> {

              }
              is Resource.Success -> {
                  println("$TAG :: Description :: ${result.result.flavor_text_entries[0].flavor_text}")
                  updateDescriptionToView(result.result.flavor_text_entries[0].flavor_text)
              }
              is Resource.Error -> {

              }
          }
        })
    }

    private fun updateDescriptionToView(description : String) {
      binding.descriptionSprites.setDescription(description)
    }

    private fun updateStripsToView() {

    }


    private fun searchClick() {
        binding.searchButton.setOnClickListener {
           searchPokemon()
        }
    }

    private fun searchPokemon() {
        val pokemonName = binding.searchEditText.text.toString()
        println("$TAG :: Pokemon Name :: $pokemonName")
        if(pokemonName.isNotEmpty()) {
            viewModel.getPokemonDetails(pokemonName)
            viewModel.getPokemonSpeciesDetails(pokemonName)
        } else {
            println("$TAG :: Pokemon Name is Empty")
        }
    }

}