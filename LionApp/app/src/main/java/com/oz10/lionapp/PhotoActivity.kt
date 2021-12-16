package com.oz10.lionapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.oz10.lionapp.databinding.ActivityPhotoBinding

class PhotoActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPhotoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPhotoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnUpload.setOnClickListener {
            binding.imgPhoto.setImageResource(R.drawable.lion)
        }

        binding.btnDiscard.setOnClickListener {
            binding.imgPhoto.setImageResource(R.drawable.aff)
        }
    }
}