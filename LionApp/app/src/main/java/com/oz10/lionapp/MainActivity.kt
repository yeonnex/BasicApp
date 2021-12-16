package com.oz10.lionapp

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.oz10.lionapp.databinding.ActivityMainBinding

// 안드로이드 뷰 바인딩 개요
//   사용자 인터페이스 레이아웃을 구성하는 뷰와 코드 간의 상호작용을 위해 코드에서 레이아웃 뷰를 사용하는 방법
//   findViewById() 함수와 합성 속성
//     안드로이드 앱을 구성하는 모든 리소스는 R 이라는 클래스로 컴파일된다
//     R -> layout -> view (사용자 인터페이스)
//     findViewById() 함수를 사용하여 R 클래스에 포함된 뷰의 참조를 얻을 수 있다
//   합성 속성 synthetic property : 코틀린 확장 플러그인을 추가
//     레이아웃 뷰에 지정한 id로 해당 뷰를 바로 사용 (findViewById() 함수 불필요)
// 뷰 바인딩
//   안드로이드 스튜디오가 app 모듈에 있는 각 레이아웃 파일의 바인딩 클래스를 자동을 생성
//     레이아웃 파일 이름을 기준으로 끝에 Binding를 붙인 클래스 생성
//     activity_main.xml -> ActivityMainBinding
//   바인딩 클래스를 사용해서 레이아웃 뷰를 사용
// 뷰 바인딩 활성화
//   프로젝트 도구 창의 Gradle Scripts -> build.gradle (Moudule:<프로젝트명>.app) 수정
//   코틀린 확장 플러그인 삭제 후 파일 수정 -> Sync Now (그래들 빌드 변경 적용)
//   android {
//      buildFeatures {
//        viewBinding true
//      }
//   }
// 뷰 바인딩을 사용하도록 변환

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        btnSend.setOnClickListener(object : View.OnClickListener {
//            override fun onClick(v: View?) {
//                val msg = etMsg.text.toString()
//                tvHello.text = msg
//                etMsg.setText("")
//            }
//        })

        binding.btnSend.setOnClickListener {
            binding.tvHello.text = binding.etMsg.text.toString()
            binding.etMsg.setText("")
        }

        binding.btnCall.setOnClickListener {
            val intent: Intent = Intent(Intent.ACTION_VIEW,
                Uri.parse("tel:010-1111-2222"))
            startActivity(intent)
        }

        binding.btnHome.setOnClickListener {
            val intent: Intent = Intent(Intent.ACTION_VIEW,
                Uri.parse("https://www.kakaocorp.com"))
            startActivity(intent)
        }
    }
}