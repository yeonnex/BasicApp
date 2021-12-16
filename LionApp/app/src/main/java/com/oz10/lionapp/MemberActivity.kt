package com.oz10.lionapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.oz10.lionapp.databinding.ActivityMemberBinding

class MemberActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMemberBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMemberBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val extras = intent.extras ?: return
        val id = extras.getString("id")
        binding.tvHello.text = id + "님 환영합니다!"
    }
}