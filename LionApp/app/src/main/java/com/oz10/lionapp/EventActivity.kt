package com.oz10.lionapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MotionEvent
import android.view.View
import com.oz10.lionapp.databinding.ActivityEventBinding

// 안드로이드 이벤트 처리 개요
// 안드로이드 이벤트는 다양하지만 주로 사용자 액션에 대한 응답으로 발생
//   입력 이벤트 input event : 터치스크린과 상호작용할 때 발생
//   이벤트 큐 event queue : 발생된 이벤트를 저장하고 유지 관리
//   이벤트 리스너 event listener : 전달된 이벤트를 처리
//     뷰가 필요로 하는 이벤트 리스너(객체)를 등록하고 이 리스너의 콜백 함수를 해당 뷰에 구현
//     binding.button.setOnClickListener( View.OnClickListener -> onClick() )  함수 호출
// 이벤트 리스너와 콜백 함수
//   binding.button.setOnClickListener(object :  View.OnClickListener {
//       override fun onClick(v: View?) { //콜백함수 구현}
//   })
//   binding.button.setOnClickListener { //콜백함수 구현 }
// 이벤트 소비 consumption : 동일한 뷰에 등록된 다음에 일치하는 이벤트 리스너에 계속 전달할 필요 여부를 결정
//   콜백함수에서 true/false 반환

// 터치와 다중 터치 이벤트 처리하기
// 터치 이벤트 처리 : OnTouchListener {v: View, m: MotionEvent -> }
//   MotionEvent 객체
//   터치 액션 : m.getActionMasked(), m.getActionIndex()
//   다중 터치 처리 : m.pointerCount, m.getPointerId(인덱스 번호 0부터)
// 다중 터치 앱
//   터치 이벤트 리스너 구현

class EventActivity : AppCompatActivity() {
    private lateinit var binding: ActivityEventBinding
    val motionEvents = mapOf(
        MotionEvent.ACTION_DOWN to "DOWN",
        MotionEvent.ACTION_UP to "UP",
        MotionEvent.ACTION_POINTER_DOWN to "POINTER_DOWN",
        MotionEvent.ACTION_POINTER_UP to "POINTER_UP",
        MotionEvent.ACTION_MOVE to "MOVE"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEventBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        binding.btnEvent.setOnClickListener(object :  View.OnClickListener {
//           override fun onClick(v: View?) {
//               binding.tvStatus.text = "Button clicked"
//           }
//        })

        binding.btnEvent.setOnClickListener {
            binding.tvStatus.text = "Button clicked"
        }

        binding.btnEvent.setOnLongClickListener {
            binding.tvStatus.text = "Long Button clicked"
//            true  // 이벤트를 소비했다는 것을 나타냄
            false   // 이벤트를 완전히 소비하지 않고 같은 타입 리스너에게 계속 전달
        }

//        binding.activityMain.setOnTouchListener(object : View.OnTouchListener {
//            override fun onTouch(v: View?, event: MotionEvent?): Boolean {
//                TODO("Not yet implemented")
//            }
//        })

        binding.tvStatus.text = "touch log 1"
        binding.tvStatus2.text = "touch log 2"

        binding.activityMain.setOnTouchListener { v: View, m: MotionEvent ->
            handleTouch(m)
            true
        }
    }

    private fun handleTouch(m: MotionEvent) {
        val pointerCount = m.pointerCount
//        binding.tvStatus.text = "pointerCount=$pointerCount, pointerId=$pointerId"
//        Log.d("Event...", "pointerCount=$pointerCount, pointerId=$pointerId")
        for (i in 0 until pointerCount) {
            val x = m.getX(i)
            val y = m.getY(i)
            val id = m.getPointerId(i)
            val action = m.actionMasked
            val actionIndex = m.actionIndex

            val actionString = motionEvents.getOrDefault(action, "")
            val touchStatus = "Action:$actionString, Index=$actionIndex, id=$id, x=$x, y=$y"
            Log.d("Event..", touchStatus)
            if (id == 0)  binding.tvStatus.text = touchStatus
            else binding.tvStatus2.text = touchStatus
        }
    }
}