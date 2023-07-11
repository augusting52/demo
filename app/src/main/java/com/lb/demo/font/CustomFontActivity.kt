package com.lb.demo.font

import android.graphics.Typeface
import android.os.Build
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.lb.demo.R

/**
 * Created by @author Alan on 2023/7/9.
 */
class CustomFontActivity: AppCompatActivity() {

    private val domeTextView by lazy { findViewById<TextView>(R.id.tv_font_weight) }
    private val btnChangeFontWeight by lazy { findViewById<Button>(R.id.btn_change_font_weight) }
    private val btnBold by lazy { findViewById<Button>(R.id.btn_bold) }
    private val btnReset by lazy { findViewById<Button>(R.id.btn_reset) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_demo_custom_font)
        initView()
    }

    private fun initView() {
        btnChangeFontWeight.setOnClickListener {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
                domeTextView.typeface = Typeface.create(Typeface.DEFAULT, 600, false)
            }

        }
        btnBold.setOnClickListener {
            domeTextView.setTypeface(domeTextView.typeface, Typeface.BOLD)

        }
        btnReset.setOnClickListener {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
                domeTextView.typeface = Typeface.create(Typeface.DEFAULT, 400, false)
            }
        }
    }

}