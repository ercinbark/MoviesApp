package com.ercin.movies.binding

import android.databinding.BindingAdapter
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.ercin.movies.util.Constant

object ImageBindingAdapter {

    @BindingAdapter("imageUrl")
    @JvmStatic
    fun loadImage(imageView: ImageView, url: String) {
        if (url.isNotEmpty()) {
            Glide.with(imageView.context)
                .load(Constant.IMAGE_BASE_URL+Constant.IMAGE_W342+url)
                .into(imageView)
        }
    }
}