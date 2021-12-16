package com.oz10.lib

// 코틀린 연산자와 표현식
// 코틀린 코드에서 변수를 사용하는 방법, 변수의 데이터는 표현식 expression 형태로 사용
// 기본적인 표현식: 연산자 operator와 두 개의 피연산자 operand로 구성
// 1 + 2 가 표현식 : val a = 1 + 2

fun main(args: Array<String>) {
    println("Operator")
    example00()
    example01()
    example02()
    example03()
    example04()
    example05()
    example06()
    example07()
}

// 연산자 우선순위
private fun example00() {
    val num1 = 456
    val result1 = num1 / 10 * 10 + 1
    val result2 = num1 - (num1 % 10 - 1)
    println("$result1, $result2")
}

// 대입 연산자: 표현식의 결과를 변수에 지정
private fun example01() {
    val num: Int  // 변수 선언
    num = 0       // 변수 초기화

    val num2 = 2  // 변수 선언과 초기화

    val d = 0.1234
    val e = 1234E-4
    println( d + e )
}

// 산술 연산자: 산술 표현식, 단항/이항 연산자
// +, -, *, /, %
private fun example02() {
    var x = -10
    x = x - 5
}

// 복합 대입 연산자: 산술 연산자와 대입 연산자를 결합한 연산자
// +=, -=, *=, /=, %=
private fun example03() {
    var x = -10
    x -= 5
}

// 증가/감소 연산자: ++, -- 단항연산자
// ++, --
private fun example04() {
    var x = 9
    val y = ++x
    val z = x++
    println("$x, $y, $z")
}

// 비교/동등 연산자: ==, !=, >, <, >=, <= 이항연산자
// ===, !== 객체비교

// 논리 연산자: !(not), ||(or), &&(and) 피 연산자와 결괏값 모두 Boolean 타입의 true나 false인 이항연산자
private fun example05() {
    println(true && true)
    println(true && false)
    println(false && true)
    println(false && false)

    println(true || true)
    println(true || false)
    println(false || true)
    println(false || false)

    println( (10 < 20) || (20 < 10) )
    println( (10 < 20) && (20 < 10) )
}

// 범위 연산자: .. 범위 range 를 선언하므로 반복 수행하는 코드에서 유용
// x..y
private fun example06() {
    for (i in 5..8) print("$i.. ")
    println()
}

// 비트 연산자 : 비트 단위의 값을 처리
//    비트 반전 inv()
//    비트 AND and()
//    비트 OR or()
//    비트 XOR xor() : 두 비트가 다르면 1, 같으면 0
//    비트 왼쪽/오른쪽 이동 shl(), shr()
private fun example07() {
    var x = 0
    var y = 3
    var z = y.inv()
    println(z)  // -4

    x = 171
    y = 3
    z = x.and(y)
    println(z)  // 3

    z = x.or(y)
    println(z)  // 171

    z = x.xor(y)
    println(z)  // 168

    x = 43
    z = x.shl(1)
    println(z)  // 86

    z = x.shr(1)
    println(z)  // 21
}

