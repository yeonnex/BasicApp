package com.oz10.lib

// 클래스 상속
// ColorPoint2D, Point3D

// ColorPoint2D
//   기존 Point2D 상속?
//   속성 color 문자열 추가, 생성자 추가
//   속성 커스텀 접근자 구현 info -> x, y, color 출력문자열 반환
//     ex) "Point2D x = 10, y = 10, color = red"
//   인스턴스 생성,  x는 10 y는 10 color 는 red
//   인스턴스 속성 커스텀 접근자 호출, x y color 값 출력
class ColorPoint2D : Point2D {
    var color: String = ""

    constructor(x: Int, y: Int, color: String) : super(x, y) {
        this.color = color
    }

    override val info: String
        get() { return super.info + ", color = $color"}
}

// Point3D
//   기존 Point2D 상속?
//   속성 z 정수 추가, 생성자 추가
//   속성 커스텀 접근자 구현 info -> x, y, z 출력문자열 반환
//     ex) "Point3D x = 10, y = 10, z = 10"
//   인스턴스 생성,  x는 10 y는 10 z는 10
//   인스턴스 속성 커스텀 접근자 호출, x y z 값 출력
class Point3D : Point2D {
    var z: Int = 0

    constructor(x: Int, y: Int, z: Int) : super(x, y) {
        this.z = z
    }

    override val info: String
        get() { return "Point3D x = $x, y = $y, z = $z"}
}

fun main(args: Array<String>) {
    val colorPoint2D = ColorPoint2D(10, 10, "red")
    println( colorPoint2D.info )

    val point3D = Point3D(10, 10, 10)
    println( point3D.info )
}