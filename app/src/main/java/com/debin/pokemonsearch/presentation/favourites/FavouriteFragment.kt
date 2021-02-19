package com.debin.pokemonsearch.presentation.favourites

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.debin.pokemonsearch.R
import com.debin.pokemonsearch.databinding.FragmentFavouriteBinding
import com.debin.pokemonsearch.pokemoncore.utils.StateResponse
import kotlinx.android.synthetic.main.fragment_favourite.*
import org.koin.android.viewmodel.ext.android.viewModel

private const val TAG = "FavouriteFragment"
class FavouriteFragment : Fragment() {

    private val viewModel: FavouriteViewModel by viewModel()
    private lateinit var binding : FragmentFavouriteBinding
    private lateinit var favouriteAdapter: FavouriteAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFavouriteBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            initViews()
            getFavouritesPokemon()
            observeFavouritePokemons()
    }

    private fun initViews() {
        favouriteAdapter = FavouriteAdapter(arrayListOf())
        rv_favourites.apply {
            adapter = favouriteAdapter
        }
    }

    private fun getFavouritesPokemon() {
        viewModel.getFavouritesPokemons()
    }

    private fun observeFavouritePokemons() {
        viewModel.favourites.observe(viewLifecycleOwner, Observer { favourites->
            when(favourites) {
                is StateResponse.Success -> {
                 favouriteAdapter.updateFavourites(favourites.data)
                }
            }
        })
    }

}