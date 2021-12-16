package com.oz10.lionapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.oz10.lionapp.databinding.ActivityJoinBinding

class JoinActivity : AppCompatActivity() {
    private lateinit var binding: ActivityJoinBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityJoinBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val extras = intent.extras ?: return
        val id = extras.getString("id")
        binding.etID.setText(id)

        binding.btnOK.setOnClickListener {
            val id = binding.etID.text.toString()
            val pw = binding.etPW.text.toString()
            val repw = binding.etRePW.text.toString()

            if (LoginActivity.members.containsKey(id) && id != "")
                binding.tvMsg.text = "이미 존재하는 아이디입니다."
            else if (pw != repw || pw == "")
                binding.tvMsg.text = "패스워드가 다르거나 없습니다."
            else {
                LoginActivity.members += id to pw

                val data = Intent()
                data.putExtra("returnData", id)
                setResult(RESULT_OK, data)
                super.finish()
            }
        }

        binding.btnCancel.setOnClickListener {
            super.finish()
        }
    }
}