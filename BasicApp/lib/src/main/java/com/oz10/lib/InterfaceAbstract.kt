package com.oz10.lib

// 코틀린 인터페이스와 추상클래스
// 개요
//   인터페이스 interface : 여러 클래스들의 공통적인 속성과 행동을 나타낼 수 있다
//     클래스는 어떻게 how 구현하는가에 초점을 두지만, 인터페이스는 무엇 what 을 구현해야 하는지를 나타낸다
//     인터페이스를 사용하면 상속 관계가 없는 클래스들 간에 속성과 함수를 공유할 수 있다
//   추상클래스 abstract class : 인터페이스와 클래스의 특성을 혼합한 클래스 타입
//     서브 클래스를 가질 수 있고 생성자도 정의할 수 있다

// 인터페이스 정의와 구현
//   interface  키워드를 사용
//	 속성은 선언만 하고 초기화하는 코드가 없고,
//   함수는 헤더만 선언하고 구현이 없는 추상 함수를 사용한다
//   인스턴스를 생성할 수 없다
interface IAnt {
    var name: String
    fun place(): String
    fun show(): String
}

// 추상클래스 정의와 구현
//   abstract 키워드를 class 키워드 앞에 사용
//   인터페이스와 비슷하게 헤더만 정의된 추상 함수와 속성을 갖는다
//   구현 코드가 있는 일반 함수를 가질 수 있다
//   인스턴스를 생성할 수 없다
abstract class Ant : IAnt {
    override var name = "Ant"

    override fun toString(): String {
        return "이름: $name " + place() + show()
    }

    override fun place(): String {
        return name + "는 동굴에서 산다."
    }

    override fun show(): String {
        return ""
    }
}

class WaterAnt : Ant() {
    override fun place(): String {
        return name + "는 water 에서 산다."
    }

    override fun show(): String {
        return "water 주변"
    }
}

class FireAnt(override var name: String) : IAnt {
    override fun place(): String {
        return name + "는 산에서 산다."
    }

    override fun show(): String {
        return "산 주변"
    }
}

fun main(args: Array<String>) {
//    displayAnt( Ant() )
    displayAnt( WaterAnt() )
    displayAnt( FireAnt("FireAnt") )
}

fun displayAnt(ant: IAnt) {
    println( ant.toString() )
    println( ant.place() )
    println( ant.show() )
}
