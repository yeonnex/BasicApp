package com.oz10.lionapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.oz10.lionapp.databinding.ActivityStatechangeBinding

// 안드로이드 앱과 액티비티 생명주기
//   안드로이드 앱은 프로세스로 실행되며, (액티비티나 서비스 및 브로드캐스트 수신자 형태의) 여러 컴포넌트로 구성된다
// 안드로이드 앱과 리소스 관리
//   모바일 장치의 제한된 리소스를 고려
//   장치 자원이 한계에 다다를 경우 시스템에서 메모리 확보를 위해 프로세스를 중단하는 등의 조치를 취한다
//   프로세스 중단을 위해 프로세스의 우선순위와 상태를 모두 고려한 중요도 서열 importance hieracty 이라는 것을 생성
// 안드로이드 프로세스 상태
//   포그라운드 프로세스
//   가시적 프로세스
//   서비스 프로세스
//   백그라운드 프로세스
//   비어 있는 프로세스
// 액티비티 생명주기
//   안드로이드 프로세스 상태는 호스팅하는 앱을 구성하는 액티비티와 컴포넌트의 상태에 의해 결정
//   액티비티의 현재 상태는 액티비티 스택 activity stack 위치에 따라 결정
// 액티비티 스택
//   push, pop, 활성화 액티비티
// 액티비티 상태
//   실행 activite/running
//   일시중지 paused
//   중단 stopped
//   소멸 killed
// 구성 변경
//   액티비티의 상태가 동적으로 변경되어 장치 구성이 변경될 경우
//   장치의 방향이 바뀌거나 시스템 폰트 설정이 변경되는 등
//   영향을 받는 액티비티 인스턴스를 소멸 및 재구성하여 변경에 응답
// 상태 변경 처리
//   내부 데이터 구조와 사용자 인터페이스 상태 저장/복원이 필요
//   상태 변경 처리 2가지 방법
//     안드로이드 운영체제가 호출해 주는 상태 변경 함수를 이용
//     Jetpack 안드로이드 아키텍처 컴포넌트에 포함된 생명주기 클래스를 사용 -> 최근 구글이 권장하는 새로운 방법

// 액티비티 상태를 저장하고 복원
// 동적 상태 저장
//   onRestoreInstanceState(savedInstanceState: Bundle?)
//   onSaveInstanceState(outState: Bundle?)
// 사용자 인터페이스 상태의 자동 저장과 복원
//   자동 저장 중지: 안드로이드 SDK 에 포함된 대부분의 뷰 위젯에 이미 구현
//   EditText > saveEnabled 속성 > false
// Bundle 클래스
//   키-값의 쌍 key-value pair으로 구성되는 데이터를 저장하는 역할
//   키는 문자열 값,
//   연관된 값은 기본형 데이터 값 또는 Parcelable 인터페이스를 구현하는 객체
//   Bundle 객체로 부터 데이터를 읽거나 저장
//     getCharSequence(), putCharSequence()
//   상태 데이터 저장하기
//     val userText = binding.editText.text
//     outState?.putCharSequence("savedText", userText)
//   상태 데이터 복원하기
//     val userText = savedInstanceState.getCharSequence("savedText")
//     binding.editText.setText(userText)
// 앱 테스트하기
//   화면 회전

class StatechangeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityStatechangeBinding
    val TAG = "StateChange"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStatechangeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Log.i(TAG, "onCreate")
    }

    override fun onStart() {
        super.onStart()
        Log.i(TAG, "onStart")

        restoreData()
    }

    override fun onPause() {
        super.onPause()
        Log.i(TAG, "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.i(TAG, "onStop")

        saveData()
    }

    override fun onRestart() {
        super.onRestart()
        Log.i(TAG, "onRestart")

        restoreData()
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i(TAG, "onDestroy")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Log.i(TAG, "onSaveInstanceState")

        val userText = binding.editText.text.toString()
        outState.putCharSequence("savedText", userText)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        Log.i(TAG, "onRestoreInstanceState")

        val userText = savedInstanceState.getCharSequence("savedText")
        binding.editText.setText(userText)
    }

    private fun restoreData() {
        val sharedPreferences = getSharedPreferences("lion", 0)
        val userText = sharedPreferences.getString("savedText", "")
        binding.editText.setText(userText)
    }

    private fun saveData() {
        val sharedPreferences = getSharedPreferences("lion", 0)
        val editor = sharedPreferences.edit()
        val userText = binding.editText.text.toString()
        editor.putString("savedText", userText)
        editor.apply()
    }
}