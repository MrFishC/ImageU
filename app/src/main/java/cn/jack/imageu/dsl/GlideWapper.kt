package cn.jack.imageu.dsl

import android.content.Context
import android.graphics.Bitmap
import android.widget.ImageView
import cn.jack.imageu.R
import com.bumptech.glide.Glide
import com.bumptech.glide.load.Transformation

/**
 * @创建者 Jack
 * @创建时间 2023/7/4
 * @描述
 */
class GlideWapper {
    var context: Context? = null
    var url: String? = null
    var imageView: ImageView? = null
    var isCircleCrop = false
    var placeholder: Int = R.drawable.icon_default_placeholder
    var error: Int = R.drawable.icon_default_placeholder
    var transform: Transformation<Bitmap>? = null
}

fun loadImage(init: GlideWapper.() -> Unit) {
    val wrap = GlideWapper()
    wrap.init()
    execute(wrap)
}

private fun execute(wrap: GlideWapper) {
    wrap.imageView?.let {
        if (wrap.context == null) {
            wrap.context = wrap.imageView!!.context
        }
        val requestBuilder = Glide
            .with(wrap.context!!)
            .load(wrap.url)
            .placeholder(wrap.placeholder)
            .error(wrap.error)
        if (wrap.isCircleCrop) {
            requestBuilder.circleCrop()
        }
        if (wrap.transform != null) {
            requestBuilder.transform(wrap.transform)
        }
        requestBuilder.into(it)
    }
}