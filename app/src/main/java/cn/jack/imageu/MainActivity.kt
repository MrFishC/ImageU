package cn.jack.imageu

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import cn.jack.lib_image.ImageU

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ImageU.init(R.drawable.icon_default_placeholder, R.drawable.icon_default_placeholder)

        val imageView = findViewById<ImageView>(R.id.image_view)

        //这里找的是http源的图片，需要在AndroidManifest的application节点配置一下 android:usesCleartextTraffic="true"
        ImageU.loadByNet(
            imageView,
            "http://pic1.win4000.com/m00/e0/5e/0b0e68b71fddfa1a0be2d33ab44b5994.jpg"
        )
    }
}