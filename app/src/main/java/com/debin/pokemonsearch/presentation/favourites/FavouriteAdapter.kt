package com.debin.pokemonsearch.presentation.favourites

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.debin.pokemonsearch.R
import com.debin.pokemonsearch.databinding.ItemLayoutFavouriteBinding
import com.debin.pokemonsearch.framework.db.PokemonFavouriteEntity

class FavouriteAdapter(private val favourites: ArrayList<PokemonFavouriteEntity>) :
    RecyclerView.Adapter<FavouriteAdapter.FavouriteViewHolder>() {

    fun updateFavourites(newFavourites: List<PokemonFavouriteEntity>) {
        favourites.clear()
        favourites.addAll(newFavourites)
        notifyDataSetChanged()
    }

    inner class FavouriteViewHolder(val binding: ItemLayoutFavouriteBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bindFavourites(favourite: PokemonFavouriteEntity) {
            binding.apply {
                binding.favourite = favourite
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavouriteViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: ItemLayoutFavouriteBinding =
            DataBindingUtil.inflate(layoutInflater, R.layout.item_layout_favourite, parent, false)
        return FavouriteViewHolder(binding)
    }

    override fun getItemCount() = favourites.size

    override fun onBindViewHolder(holder: FavouriteViewHolder, position: Int) {
        val favourite = favourites[position]
        holder.bindFavourites(favourite)
    }

    fun removeAt(position: Int) {
        favourites.removeAt(position)
        notifyItemRemoved(position)
    }
}