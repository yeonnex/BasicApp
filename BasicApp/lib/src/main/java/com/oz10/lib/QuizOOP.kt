package com.oz10.lib

// 클래스 생성
// Person, Point2D, Student

// Person
//   속성 name 문자열
//   기본 생성자 구현
//   인스턴스 생성,  name 본인 이름
//   인스턴스 속성 호출, name 값 출력
// class Person (val name: String) { }
class Person {
    var name: String = ""

    constructor(name: String) {
        this.name = name
    }
}

// Point2D
//   속성 x, y 정수
//   기본 생성자 구현
//   속성 커스텀 접근자 구현 info -> x, y 출력문자열 반환
//     ex) "Point2D x = 10, y = 10"
//   인스턴스 생성,  x는 10 y는 10
//   인스턴스 속성 커스텀 접근자 호출, x y값 출력
open class Point2D (var x: Int, var y: Int) {
    open val info: String
        get() { return "Point2D x = $x, y = $y"}
}

// Student
//   속성 name, course 문자열
//   기본 생성자 구현
//   속성 커스텀 접근자 구현 info -> name, course 출력문자열 반환
//     ex) "student name = park, course = 안드로이드"
//   인스턴스 생성,  name 본인 이름, course 안드로이드
//   인스턴스 속성 커스텀 접근자 호출, name, course 값 출력
class Student (var name: String, var course: String) {
    val info: String
        get() { return "student name = $name, course = $course"}
}


fun main(args: Array<String>) {
    val person: Person = Person("park")
    println(person.name)

    val point2D: Point2D = Point2D(10, 10)
    println( point2D.info )

    val student: Student = Student("park", "안드로이드")
    println( student.info )
}