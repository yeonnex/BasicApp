package com.oz10.lionapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.GestureDetector
import android.view.MotionEvent
import androidx.core.view.GestureDetectorCompat
import com.oz10.lionapp.databinding.ActivityGestureBinding

// 안드로이드 제스처
// 리스너 클래스 구현하기
//   GestureDetector.OnGestureListener, GestureDetector.OnDoubleTapListener

// 안드로이드 제스처 감지 클래스로 일반 제스처 처리하기
// 제스처 gesture : 터치스크린과 사용자 간의 연속적인 상호작용을 정의
//   페이지 밀어서 넘기기
//   이미지를 두 손가락으로 줌인/줌아웃
// 일반 제스처 감지와 처리 : GestureDetector 클래스 사용
//   리스너 클래스 구현
//     GestureDetector.OnGestureListener,
//     GestureDetector.OnDoubleTapListener 인터페이스를 구현하는 클래스를 생성
//   GestureDetectorCompat 인스턴스 생성
//   onTouchEvent() 함수 구현
//   앱 테스트

class GestureActivity : AppCompatActivity(),
    GestureDetector.OnGestureListener, GestureDetector.OnDoubleTapListener {
    private lateinit var binding: ActivityGestureBinding
    var gestureDetector: GestureDetectorCompat? = null
    val TAG = "GestureEvent"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGestureBinding.inflate(layoutInflater)
        setContentView(binding.root)

        this.gestureDetector = GestureDetectorCompat(this, this)
        this.gestureDetector?.setOnDoubleTapListener(this)
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        this.gestureDetector?.onTouchEvent(event)
        Log.i(TAG, "onTouchEvent")
        return super.onTouchEvent(event)
    }

    override fun onDown(e: MotionEvent?): Boolean {
        binding.tvGestureStatus.text = "onDown"
        Log.i(TAG, "onDown")
        return true
    }

    override fun onShowPress(e: MotionEvent?) {
        binding.tvGestureStatus.text = "onShowPress"
        Log.i(TAG, "onShowPress")
    }

    override fun onSingleTapUp(e: MotionEvent?): Boolean {
        binding.tvGestureStatus.text = "onSingleTapUp"
        Log.i(TAG, "onSingleTapUp")
        return true
    }

    override fun onScroll(
        e1: MotionEvent?,
        e2: MotionEvent?,
        distanceX: Float,
        distanceY: Float
    ): Boolean {
        binding.tvGestureStatus.text = "onScroll"
        Log.i(TAG, "onScroll")
        return true
    }

    override fun onLongPress(e: MotionEvent?) {
        binding.tvGestureStatus.text = "onLongPress"
        Log.i(TAG, "onLongPress")
    }

    override fun onFling(
        e1: MotionEvent?,
        e2: MotionEvent?,
        velocityX: Float,
        velocityY: Float
    ): Boolean {
        binding.tvGestureStatus.text = "onFling"
        Log.i(TAG, "onFling")
        return true
    }

    override fun onSingleTapConfirmed(e: MotionEvent?): Boolean {
        binding.tvGestureStatus.text = "onSingleTapConfirmed"
        Log.i(TAG, "onSingleTapConfirmed")
        return true
    }

    override fun onDoubleTap(e: MotionEvent?): Boolean {
        binding.tvGestureStatus.text = "onDoubleTap"
        Log.i(TAG, "onDoubleTap")
        return true
    }

    override fun onDoubleTapEvent(e: MotionEvent?): Boolean {
        binding.tvGestureStatus.text = "onDoubleTapEvent"
        Log.i(TAG, "onDoubleTapEvent")
        return true
    }
}