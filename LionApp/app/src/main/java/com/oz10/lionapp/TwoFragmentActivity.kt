package com.oz10.lionapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.oz10.lionapp.databinding.ActivityTwoFragmentBinding

// 안드로이드 프래그먼트
// Fragment : 액티비티 내부에서 독립적으로 앱의 UI를 처리
// UI 모듈화
// 프래그먼트는 혼자 독립은 안되고, 액티비티의 일부로만 쓰임
// 런타임 시 UI를 동적으로 변경하기 위해 사용
// 프래그먼트 생성
//  Fragment 클래스의 서브 클래스 생성
//  onCreateView() 함수를 오버라이딩해서 프래그먼트 레이아웃을 로드
// 프래그먼트 이벤트 처리
//  이벤트 시스템을 사용! Listener 에다 동작 등록

// Material 디자인 전부 프래그먼트로 되어있음
// 구글맵 자체도 프래그먼트로 이루어져있음
// 프래그먼트 꼭 알아야 함

class TwoFragmentActivity : FragmentActivity() {
    private lateinit var binding: ActivityTwoFragmentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTwoFragmentBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_two_fragment)

        binding.btnOK.setOnClickListener {
            val txt = binding.etMsg.text.toString()
            val fragment = supportFragmentManager.findFragmentById(
                R.id.fragmentContainerView) as OneFragment
            if (fragment is OneFragment) // 인스턴스 비교
                (fragment as OneFragment).changeText(text)
            else
                (fragment as TwoFragment).changeText(text)

        }
        binding.btnTwo.setOnClickListener {
            val fragment = TwoFramgent()
            fragment.arguments = intent.extras
            supportFragmentManager.beginTransaction().replace(
                R.id.fragmentContainerView, fragment).commit()
            )
        }
        binding.btnOK.setOnClickListener {
            val fragment = OneFramgent()
            fragment.arguments = intent.extras
            supportFragmentManager.beginTransaction().replace(
                R.id.fragmentContainerView, fragment).commit()
            )
        }
    }
}