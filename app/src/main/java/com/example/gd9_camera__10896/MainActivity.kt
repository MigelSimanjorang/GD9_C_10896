package com.example.gd9_camera__10896

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Context
import android.view.SurfaceHolder
import android.view.SurfaceView
import android.hardware.Camera
import android.util.Log
import android.view.View
import android.widget.FrameLayout
import android.widget.ImageButton
import java.io.IOException
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    private var mCamera: Camera? =null
    private var mCameraView: CameraView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        try {
            mCamera = Camera.open()
        } catch (e:Exception) {
            Log.d("Error", "Failed to get Camera" + e.message)
        }
        if (mCamera != null) {
            mCameraView = CameraView(this,mCamera!!)
            val camera_view = findViewById<View>(R.id.FLCamera) as FrameLayout
            camera_view.addView(mCameraView)
        }
        @SuppressLint("MissingInflatedid", "LocalSupress") val imageClose =
            findViewById<View>(R.id.imgClose) as ImageButton
        imageClose.setOnClickListener{ view: View? -> System.exit(0)}
    }
}