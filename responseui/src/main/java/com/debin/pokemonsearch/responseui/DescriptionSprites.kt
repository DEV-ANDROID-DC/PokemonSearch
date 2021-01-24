package com.debin.pokemonsearch.responseui

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import com.debin.pokemonsearch.responseui.databinding.LayoutDescriptionSpritesBinding


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

    fun showErrorDescription(error : String) {
        binding.tvErrorDescription.visibility = View.VISIBLE
        binding.tvErrorDescription.text = error
    }

    fun showErrorSprites(error: String) {
        binding.tvErrorSprites.visibility = View.VISIBLE
        binding.tvErrorSprites.text = error
    }

    fun hideErrorDescription() {
        binding.tvErrorDescription.visibility = View.GONE
        binding.tvErrorDescription.text = ""
    }

    fun hideErrorSprites() {
        binding.tvErrorSprites.visibility = View.GONE
        binding.tvErrorSprites.text = ""
    }

    fun showProgressDescription() {
        binding.progressBarForDescription.visibility = View.VISIBLE
    }

    fun hideProgressDescription() {
        binding.progressBarForDescription.visibility = View.GONE
    }

    fun showProgressStripes() {
        binding.progressBarForSprites.visibility = View.VISIBLE
    }

    fun hideProgressStripes() {
        binding.progressBarForSprites.visibility = View.GONE
    }


}