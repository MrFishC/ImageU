package cn.jack.lib_image

import android.widget.ImageView
import cn.jack.lib_image.manager.GlideManager
import cn.jack.lib_image.manager.ImageManager

/**
 * @创建者 Jack
 * @创建时间 2021/3/16
 * @描述 直接调用该类的Api去加载图片即可,用户只需要使用该类的api即可
 */
class ImageU {
    companion object {
        fun init(loadingResId: Int = 0, loadErrorResId: Int = 0) {
            val gm = GlideManager.Builder()
                .setLoadingResId(loadingResId)
                .setLoadErrorResId(loadErrorResId)
                .create()
            ImageManager.getInstance().init(gm)
        }

        fun loadByNet(view: ImageView, url: String) {
            ImageManager.getInstance().getImageLoader().loadImageByNet(view.context, url, view)
        }
    }
}