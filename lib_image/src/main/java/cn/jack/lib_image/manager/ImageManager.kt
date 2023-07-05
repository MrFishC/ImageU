package cn.jack.lib_image.manager

import cn.jack.lib_image.interf.IImageLoader

/**
 * @创建者 Jack
 * @创建时间 2021/3/11
 * @描述 图片加载管理者
 */
internal class ImageManager private constructor() {

    companion object {
        @Volatile
        private var instance: ImageManager? = null

        fun getInstance(): ImageManager = instance ?: synchronized(this) {
            instance ?: ImageManager().also { instance = it }
        }
    }

    private var mImageLoader: IImageLoader? = null

    /**
     * 初始化图片加载框架，建议在application中调用
     * @param imageLoader 指定的图片加载框架
     */
    fun init(imageLoader: IImageLoader) {
        mImageLoader = imageLoader
    }

    fun getImageLoader(): IImageLoader {
        if (mImageLoader == null) {
            throw RuntimeException("ImageU(IImageLoader)'s init function must be call frist!")
        }
        return mImageLoader!!
    }
}