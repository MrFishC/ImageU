package cn.jack.imageu

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import cn.jack.imageu.dsl.loadImage
import cn.jack.lib_image.ImageU

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ImageU.init(R.drawable.icon_default_placeholder, R.drawable.icon_default_placeholder)

        val imageView1 = findViewById<ImageView>(R.id.image_view)
        val imageView2 = findViewById<ImageView>(R.id.image_view2)

        //这里找的是http源的图片，需要在AndroidManifest的application节点配置一下 android:usesCleartextTraffic="true"
        ImageU.loadByNet(
            imageView1,
            "http://pic1.win4000.com/m00/e0/5e/0b0e68b71fddfa1a0be2d33ab44b5994.jpg"
        )

        //dsl
        loadImage {
            url = "http://pic1.win4000.com/m00/e0/5e/0b0e68b71fddfa1a0be2d33ab44b5994.jpg"
            imageView = imageView2
            isCircleCrop = true
        }
    }
}