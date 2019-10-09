package com.infinityspark.clockworkorange

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private lateinit var mediaPlayer: MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var number = (Math.floor(Math.random()).toInt()%2)
        var name = "grizzly" + number.toString()
        var resource = getResources().getIdentifier(name, "raw","com.infinityspark.clockworkorange")
        mediaPlayer = MediaPlayer.create(this,resource)
        // mediaPlayer = MediaPlayer.create(this,R.raw.grizzly)
        var playing = false
        button.setOnClickListener{
            if(playing){
                mediaPlayer.stop()
                playing = false
                number = Random.nextInt(0, 2)
                name = "grizzly" + number.toString()
                resource = getResources().getIdentifier(name, "raw","com.infinityspark.clockworkorange")
                mediaPlayer = MediaPlayer.create(this,resource)
                var replacer = getResources().getDrawable(R.drawable.black_button)
                button.setImageDrawable(replacer)
            }
            else{
                var replacer = getResources().getDrawable(R.drawable.black_stop)
                mediaPlayer.start()
                playing = true
                button.setImageDrawable(replacer)
            }
        }

    }
}
