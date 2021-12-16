package com.oz10.lionapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.oz10.lionapp.databinding.ActivityMission04Binding

class Mission04Activity : AppCompatActivity() {
    private lateinit var binding: ActivityMission04Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMission04Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnUp.setOnClickListener {
            binding.imgA.setImageResource(R.drawable.lion)
            binding.imgB.setImageResource(R.drawable.aff)
        }

        binding.btnDown.setOnClickListener {
            binding.imgA.setImageResource(R.drawable.aff)
            binding.imgB.setImageResource(R.drawable.lion)
        }
    }
}