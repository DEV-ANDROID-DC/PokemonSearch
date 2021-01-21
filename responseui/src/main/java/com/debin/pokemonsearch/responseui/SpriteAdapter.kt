package com.debin.pokemonsearch.responseui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.debin.pokemonsearch.responseui.databinding.CardSpriteBinding
import com.debin.pokemonsearch.responseui.utils.getProgressDrawable
import com.debin.pokemonsearch.responseui.utils.loadImage

class SpriteAdapter(private val spritesList : ArrayList<String>) : RecyclerView.Adapter<SpriteAdapter.SpriteViewHolder>() {

    fun updateSprites(newSprites : List<String>) {
         spritesList.clear()
         spritesList.addAll(newSprites)
         notifyDataSetChanged()
    }

    inner class SpriteViewHolder(private val binding: CardSpriteBinding) : RecyclerView.ViewHolder(binding.root){
        val progressDrawable = getProgressDrawable(binding.root.context)
       fun bindImage(uriImage : String) {
           binding.imgSprite.loadImage(uriImage, progressDrawable)
       }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SpriteViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = CardSpriteBinding.inflate(layoutInflater, parent, false)
        return SpriteViewHolder(binding)
    }

    override fun getItemCount() = spritesList.size

    override fun onBindViewHolder(holder: SpriteViewHolder, position: Int) {
        val image = spritesList[position]
        holder.bindImage(image)
    }

}