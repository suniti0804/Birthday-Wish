package com.project4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.project4.databinding.ActivityGreetingBinding
import com.project4.databinding.ActivityMainBinding

class GreetingActivity : AppCompatActivity() {

    private lateinit var binding: ActivityGreetingBinding

    companion object{
        const val NAME_EXTRA="name_extra"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityGreetingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val name = intent.getStringExtra(NAME_EXTRA)
        binding.birthdayGreeting.text = String.format("Happy Birthday \n %s !",name)
    }

}