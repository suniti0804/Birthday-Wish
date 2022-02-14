package com.project4

import android.media.AudioAttributes
import android.media.MediaPlayer
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.RequiresApi
import com.project4.databinding.ActivityGreetingBinding
import com.project4.databinding.ActivityMainBinding

class GreetingActivity : AppCompatActivity() {

    private lateinit var binding: ActivityGreetingBinding

    companion object{
        const val NAME_EXTRA="name_extra"
    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityGreetingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val name = intent.getStringExtra(NAME_EXTRA)
        binding.birthdayGreeting.text = String.format("Happy Birthday Dear \n %s !",name)

        try{
            val mediaPlayer = MediaPlayer.create(this, R.raw.song)
            mediaPlayer.setAudioAttributes(
                AudioAttributes.Builder().setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                    .setUsage(AudioAttributes.USAGE_MEDIA)
                    .build()
            )
            mediaPlayer.isLooping = true
            mediaPlayer.start()
        }

        catch (e:Exception){
            e.printStackTrace()
        }
    }


}