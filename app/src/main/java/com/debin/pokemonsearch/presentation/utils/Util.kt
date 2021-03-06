package com.debin.pokemonsearch.presentation.utils

import android.content.Context
import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.debin.pokemonsearch.R
import com.google.android.material.snackbar.Snackbar


fun getProgressDrawable(context: Context): CircularProgressDrawable {
    return CircularProgressDrawable(context).apply {
        strokeWidth = 10f
        centerRadius = 50f
        start()
    }
}

@BindingAdapter("imageUrl")
fun ImageView.loadImage( uri : String?) {
    val options = RequestOptions()
        .placeholder(getProgressDrawable(this.context))
        .error(R.mipmap.ic_launcher)
    Glide.with(this.context)
        .setDefaultRequestOptions(options)
        .load(uri)
        .into(this)
}

fun makeSnackBar(context: Context, view: View, message: String) : Snackbar {
    return Snackbar.make(view, message, Snackbar.LENGTH_LONG)
}