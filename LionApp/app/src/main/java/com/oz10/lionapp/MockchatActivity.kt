package com.oz10.lionapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.oz10.lionapp.databinding.ActivityMockchatBinding

class MockchatActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMockchatBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMockchatBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnChatSend.setOnClickListener {
            val msg = binding.etChatMsg.text.toString()
            binding.tvMsg.append(msg + "\n")
            binding.etChatMsg.setText("")
        }
    }
}