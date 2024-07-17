/*
 * Copyright 2017 Pavel Semak
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.sample

import android.graphics.PixelFormat
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.activity.ComponentActivity
import androidx.appcompat.app.AppCompatActivity
import com.alphamovie.lib.AlphaMovieView

class MainActivity2 : ComponentActivity() {
    private var alphaMovieView: AlphaMovieView? = null
    private var imageViewBackground: ImageView? = null
    private var bgIndex = FIRST_BG_INDEX
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        window.setFormat(PixelFormat.TRANSLUCENT)
        imageViewBackground = findViewById(R.id.image_background) as ImageView
        alphaMovieView = findViewById(R.id.video_player) as AlphaMovieView
        alphaMovieView!!.setVideoFromAssets(FILENAME)
    }

    public override fun onResume() {
        super.onResume()
        alphaMovieView!!.onResume()
    }

    public override fun onPause() {
        super.onPause()
        alphaMovieView!!.onPause()
    }

    fun play(view: View?) {
        alphaMovieView!!.start()
    }

    fun pause(view: View?) {
        alphaMovieView!!.pause()
    }

    fun stop(view: View?) {
        alphaMovieView!!.stop()
    }

    fun changeBackground(view: View?) {
        bgIndex = ++bgIndex % BG_ARRAY_LENGTH
        imageViewBackground!!.setImageResource(backgroundResources[bgIndex])
    }

    companion object {
        const val FILENAME = "ball.mp4"
        const val FIRST_BG_INDEX = 0
        const val BG_ARRAY_LENGTH = 3
        val backgroundResources = intArrayOf(
            R.drawable.court_blue,
            R.drawable.court_green, R.drawable.court_red
        )
    }
}