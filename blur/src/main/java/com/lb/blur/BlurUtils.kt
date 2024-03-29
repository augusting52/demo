package com.lb.blur

import android.content.Context
import android.graphics.Bitmap
import android.renderscript.Allocation
import android.renderscript.Element
import android.renderscript.RenderScript
import android.renderscript.ScriptIntrinsicBlur


/**
 * Created by @author Alan on 2023/6/28.
 */
class BlurUtils private constructor() {

    companion object {
        private val BITMAP_SCALE = 1f
        private val BLUR_RADIUS = 25f

        fun blur(context: Context, image: Bitmap): Bitmap? {
//            val width = Math.round(image.width * BITMAP_SCALE)
//            val height = Math.round(image.height * BITMAP_SCALE)
            val inputBitmap = Bitmap.createScaledBitmap(image, image.width, image.height, false)
            val outputBitmap = Bitmap.createBitmap(inputBitmap)
            val rs = RenderScript.create(context)
            val theIntrinsic = ScriptIntrinsicBlur.create(rs, Element.U8_4(rs))
            val tmpIn = Allocation.createFromBitmap(rs, inputBitmap)
            val tmpOut = Allocation.createFromBitmap(rs, outputBitmap)
            theIntrinsic.setRadius(BLUR_RADIUS)
            theIntrinsic.setInput(tmpIn)
            theIntrinsic.forEach(tmpOut)
            tmpOut.copyTo(outputBitmap)
            return outputBitmap
        }
    }

}