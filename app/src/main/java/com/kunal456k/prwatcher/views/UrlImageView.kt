package com.kunal456k.prwatcher.views

import android.content.Context
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.kunal456k.prwatcher.R

class UrlImageView : AppCompatImageView {
    var placeHolderSrc: Drawable? = null
    var brokenImageSrc: Drawable? = null

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        checkCustomFields(context, attrs)
    }

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        checkCustomFields(context, attrs)
    }

    private fun checkCustomFields(context: Context, attrs: AttributeSet?) {
        val a = context.obtainStyledAttributes(attrs, R.styleable.UrlImageView, 0, 0)
        placeHolderSrc = a.getDrawable(R.styleable.UrlImageView_placeHolderSrc)
        brokenImageSrc = a.getDrawable(R.styleable.UrlImageView_brokenImageSrc)
        a.recycle()
    }
}

@BindingAdapter(value = ["imageUrl"])
fun setImageUrl(imageView: UrlImageView, imageUrl: String?) {
    imageUrl?.let {
        Glide.with(imageView.context).load(it).fitCenter()
            .placeholder(imageView.placeHolderSrc)
            .error(imageView.brokenImageSrc).fitCenter().into(imageView)
    }
}