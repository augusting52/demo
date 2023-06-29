package com.lb.demo.blur

import android.graphics.BitmapFactory
import android.graphics.RenderEffect
import android.graphics.Shader
import android.os.Build
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.lb.blur.BlurUtils
import com.lb.demo.R

/**
 * Created by @author Alan on 2023/6/27.
 */
class BlurActivityDemo: AppCompatActivity() {

    private val demoImage by lazy { findViewById<ImageView>(R.id.iv_image_demo) }
    private val btnBlur by lazy { findViewById<Button>(R.id.btn_blur) }
    private val btnBlur2 by lazy { findViewById<Button>(R.id.btn_blur2) }
    private val btnReset by lazy { findViewById<Button>(R.id.btn_reset) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_demo_blur)
        initView()
    }

    private fun initView() {
        demoImage.setImageResource(R.drawable.blur_test)
        btnBlur2.setOnClickListener {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
                val blurEffect = RenderEffect.createBlurEffect(0F,
                    1.0F, Shader.TileMode.CLAMP)
                demoImage.setRenderEffect(blurEffect)
            }
        }
        btnBlur.setOnClickListener {
            val srcBitmap = BitmapFactory.decodeResource(resources, R.drawable.blur_test)
            demoImage.setImageBitmap(BlurUtils.blur(this, srcBitmap))
        }
        btnReset.setOnClickListener {
            demoImage.setImageResource(R.drawable.blur_test)
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
                demoImage.setRenderEffect(null)
            }
        }
    }
}