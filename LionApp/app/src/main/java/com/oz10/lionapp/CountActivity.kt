package com.oz10.lionapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.oz10.lionapp.databinding.ActivityCountBinding

// 안드로이드 뷰, 뷰 그룹, 레이아웃
//   안드로이드 사용자 인터페이스를 구성하는 요소
//   서로 다른 안드로이드 장치를 위한 디자인을 고려
// 뷰와 뷰 그룹
//   위젯 widget 또는 컴포넌트 component:
//     안드로이드 사용자 인터페이스를 구성하는 데 사용되는 View 클래스에서 파생(상속)된 클래스
//   복합 뷰 composite view: 여러 개의 다른 뷰로 구성된 ViewGroup 클래스에서 파생(상속)된 클래스
//     복합 뷰는 다른 뷰를 자식뷰 child view 로 포함할 수 있는 하나의 부모뷰 parent view 로 구성
//     부모뷰는 컨테이너 뷰 container view 또는 루트 요소 root element
// 안드로이드 레이아웃 매니저
//   ConstraintLayout
//   LinearLayout
//   TableLayout
//   FrameLayout
//   RelativeLayout
//   AbsoluteLayout
//   GridLayout
//   CoordinatorLayout
// 뷰 계층 구조
//   뷰 계층 구조는 계층 구조 트리
//   맨 위의 루트뷰와 자식뷰로 이루어짐
// 사용자 인터페이스 디자인 방법 3가지
//   안드로이드 스튜디오 레이아웃 편집기를 사용하는 방법
//   XML 레이아웃 리소스 파일을 직접 작성하는 방법
//   (코틀린) 코드로 작성하는 방법

class CountActivity : AppCompatActivity() {
    private var count: Int = 0
    private lateinit var binding: ActivityCountBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCountBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnCount.setOnClickListener {
            count++
            binding.tvCnt.text = count.toString()
        }
    }
}