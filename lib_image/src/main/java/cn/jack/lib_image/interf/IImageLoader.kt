package cn.jack.lib_image.interf

import android.content.Context
import android.widget.ImageView

/**
 * @创建者 Jack
 * @创建时间 2021/3/11
 * @描述 定义图片加载的方法(具体的方法根据实际的业务需求定制)
 */
internal interface IImageLoader {
    fun loadImageByNet(context: Context, url: String, imageView: ImageView)
}