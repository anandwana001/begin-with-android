package com.akshay.dragonballteam.DataBinding

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

/**
 * Created by akshaynandwana on
 * 07, May, 2020
 **/

@BindingAdapter("app:glideImage")
fun setImageView(imageView: ImageView, url: String) {
    Glide.with(imageView.context)
        .load(url)
        .into(imageView)
}