package com.debin.pokemonsearch.presentation.search

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.debin.pokemonsearch.databinding.FragmentSearchBinding
import com.debin.pokemonsearch.presentation.utils.Resource
import com.debin.pokemonsearch.presentation.utils.makeSnackBar
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
            observePokemon()
            observePokemonSpecies()
            searchEditTextClick()
            addToFavourite()
    }


    private fun observePokemon() {
        viewModel.pokemon.observe(viewLifecycleOwner, Observer { result ->
            when(result) {
                is Resource.Loading -> {
                    showProgressSprites()
                   // hideErrorSprites()
                }
                is Resource.Success -> {
                    hideProgressSprites()
                    hideProgressSprites()
                    val sprites = result.result.sprites
                    updateStripsToView(spritesList(sprites.back_female, sprites.back_shiny_female, sprites.back_default, sprites.front_female,
                              sprites.front_shiny_female, sprites.back_shiny, sprites.front_default, sprites.front_shiny))
                    showFavouriteButton()
                }
                is Resource.Error -> {
                    hideProgressSprites()
                    hideFavouriteButton()
                    errorOccurredSprites(result.mgs.toString())
                }
            }
        })
    }

    private fun observePokemonSpecies() {
        viewModel.pokemonSpecies.observe(viewLifecycleOwner, Observer {result ->
          when(result) {
              is Resource.Loading -> {
                  showProgressDescription()
                 // hideErrorDescription()
              }
              is Resource.Success -> {
                  hideProgressDescription()
                  hideErrorDescription()
                  println("$TAG :: Description :: ${result.result.flavor_text_entries[0].flavor_text}")
                  updateDescriptionToView(result.result.flavor_text_entries[0].flavor_text)
                  showFavouriteButton()
              }
              is Resource.Error -> {
                  hideProgressDescription()
                  hideFavouriteButton()
                  errorOccurredDescription(result.mgs.toString())
              }
          }
        })
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

    private fun spritesList(backFemale : String, backShinyFemale : String, backDefault : String,
                            frontFemale : String, frontShinyFemale : String, backShiny : String,
                            frontDefault : String, frontShiny : String) : List<String> {
        return listOf(backFemale, backShinyFemale, backDefault,
            frontFemale, frontShinyFemale, backShiny, frontDefault, frontShiny)
    }

    private fun addToFavourite() {
        binding.buttonFavourite.setOnClickListener {
            findNavController().navigate(SearchFragmentDirections.actionSearchFragmentToFavouriteFragment())
            viewModel.addToFavourite()
        }
    }

    private fun updateDescriptionToView(description : String) {
        binding.descriptionSprites.setDescription(description)
    }

    private fun updateStripsToView(sprites : List<String>) {
        binding.descriptionSprites.setSprites(sprites)
    }

    private fun showProgressDescription() {
        binding.descriptionSprites.showProgressDescription()
    }

    private fun hideProgressDescription() {
        binding.descriptionSprites.hideProgressDescription()
    }

    private fun showProgressSprites() {
        binding.descriptionSprites.showProgressStripes()
    }

    private fun hideProgressSprites() {
        binding.descriptionSprites.hideProgressStripes()
    }

    private fun errorOccurredDescription(error: String) {
        binding.descriptionSprites.setSprites(listOf())
        binding.descriptionSprites.showErrorDescription(error)
    }

    private fun errorOccurredSprites(error: String) {
        binding.descriptionSprites.setDescription("")
        binding.descriptionSprites.showErrorSprites(error)
    }

    private fun hideErrorDescription() {
        binding.descriptionSprites.hideErrorDescription()
    }

    private fun hideErrorSprites() {
        binding.descriptionSprites.hideErrorSprites()
    }

    private fun showFavouriteButton() {
        binding.buttonFavourite.visibility = View.VISIBLE
    }

    private fun hideFavouriteButton() {
        binding.buttonFavourite.visibility = View.GONE
    }

    private fun showError(error : String) {
        makeSnackBar(requireContext(), requireView(), error).show()
    }

    private fun searchEditTextClick() {
        binding.searchEditText.setOnClickListener {
            hideErrorDescription()
            hideErrorSprites()
        }
    }

    // check Text Wrapper

}