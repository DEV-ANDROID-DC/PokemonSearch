package com.debin.pokemonsearch.responseui

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import com.debin.pokemonsearch.responseui.databinding.LayoutDescriptionSpritesBinding
import com.debin.pokemonsearch.responseui.utils.getProgressDrawable
import com.debin.pokemonsearch.responseui.utils.loadImage
import kotlinx.android.synthetic.main.card_sprite.view.*


class DescriptionSprites @JvmOverloads constructor(
    private val ctx: Context,
    private val attributeSet: AttributeSet? = null,
    private val defStyleAttr: Int = 0
) : ConstraintLayout(ctx, attributeSet, defStyleAttr) {

    private var binding: LayoutDescriptionSpritesBinding
    private lateinit var adapter: SpriteAdapter

    init {
        val inflater = ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        binding = LayoutDescriptionSpritesBinding.inflate(inflater, this)
    }

    fun setDescription(description: String) {
        binding.tvDescription.text = description
    }

    fun setSprites(spriteList : List<String>) {
        adapter = SpriteAdapter(arrayListOf())
        binding.rvStrips.adapter = adapter
        adapter.updateSprites(spriteList)
    }

}