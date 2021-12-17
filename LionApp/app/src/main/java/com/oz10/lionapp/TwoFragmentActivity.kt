package com.oz10.lionapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity

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

class TwoFragmentActivity : FragmentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_two_fragment)
    }
}