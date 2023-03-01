package com.example.onlineshop.base

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.util.Base64

object ImageDecoder {
    private const val DECODE_BYTE_ARRAY_OFFSET = 0

    fun decodeImage(imageString: String): Bitmap {
        val decodedString: ByteArray = Base64.decode(imageString, Base64.DEFAULT)
        return BitmapFactory.decodeByteArray(decodedString, DECODE_BYTE_ARRAY_OFFSET, decodedString.size)
    }
}