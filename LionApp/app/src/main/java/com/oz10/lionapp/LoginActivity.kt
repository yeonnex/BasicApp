package com.oz10.lionapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.oz10.lionapp.databinding.ActivityLoginBinding

// 안드로이드 화면전환과 값전달
// 인텐트 개요
//   인텐트는 하나의 액티비티가 다른 액티비티를 시작시킬 수 있는 메시징 시스템
//   인텐트를 전송한 액티비티에서 수신한 액티비티에 데이터 전달 가능
//     키-값 쌍으로 된 데이터를 Bundle 객체에 넣어 인텐트에 포함
//   액티비티에서 데이터 반환 :
//     인텐트 수신 액티비티는 송신 액티비티의 서브 액티비티로 시작되어야만 결과 데이터를 반환할 수 있다
//   인텐트는 서비스 service 와 브로드캐스트 수신자 broadcast receiver 를 시작시키고 통신할 수도 있다
//   인텐트는 명시적 explicit 과 암시적 implicit 의 두 가지로 분류
// 명시적 인텐트
//   수신 액티비티의 컴포넌트 이름(실제로는 클래스 이름)을 참조하여 특정 액티비티의 시작을 요청할 때 사용
// 암시적 인텐트
//   수행될 액션과 수신 액티비티에 의해 처리되는 데이터 타입을 지정하여 시작될 액티비티를 식별
//   인텐트 필터 intent filter : 액티비티가 자신이 지원하는 액션과 데이터 처리 능력을 안드로이드 인텐트 레졸루션 프로세스에 알리는 메커니즘

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private val request_code = 5
    companion object {
        var members = mapOf("tester" to "1234", "admin" to "1234", "user" to "1234")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLogin.setOnClickListener {
            val id = binding.etID.text.toString()
            val pw = binding.etPW.text.toString()

            if (members.containsKey(id)) {
                if (members[id] != pw) {
                    binding.tvMsg.text = "비번이 다릅니다."
                } else {
                    initUI()

                    val intent = Intent(this@LoginActivity, MemberActivity::class.java)
                    intent.putExtra("id", id)
                    startActivity(intent)
                }
            } else {
                initUI()
                val intent = Intent(this@LoginActivity, JoinActivity::class.java)
                intent.putExtra("id", id)
                startActivityForResult(intent, request_code)
            }
        }

        binding.btnCancel.setOnClickListener {
            super.finish()
        }
    }

    private fun initUI() {
        binding.tvMsg.text = ""
        binding.etID.setText("")
        binding.etPW.setText("")
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if ((requestCode == request_code) && (resultCode == RESULT_OK)) {
            data?.let {
                if (it.hasExtra("returnData")) {
                    val returnString = it.extras?.getString("returnData")
                    binding.etID.setText(returnString)
                }
            }
        }
    }
}