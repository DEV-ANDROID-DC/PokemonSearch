package com.debin.pokemonsearch.presentation.favourites

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.debin.pokemonsearch.R
import org.koin.android.viewmodel.ext.android.viewModel

class FavouriteFragment : Fragment() {

    private val viewModel: FavouriteViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_favourite, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
           //viewModel.getFunTest()
    }

}