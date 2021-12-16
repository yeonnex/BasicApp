package com.oz10.lib

// 코틀린의 함수 function 와 람다 lambda :
//   잘 조직되고 효율적인 코드를 작성하는 데 필요한 필수 요소이며
//   중복을 피하면서 프로그램을 구성하는 방법을 제공

fun main(args: Array<String>) {
    println("Function & Lambda")

    println("Function..")
    example01()
    example02()
    example03()
    example04()
    example05()

    println("Lambda..")
    example06()
    example07()
    example08()
    example09()
}

// 함수란?: 특정 작업을 수행하기 위해 호출될 수 있는 이름이 있는 코드 블록
// 함수는 작업 수행에 필요한 데이터를 받으며 자신을 호출한 코드로 결과를 반환할 수 있다.
// 함수 구성: 이름, 매개변수, 반환 타입, 몸체(실행 코드)
// 함수 선언
// fun <함수명> (<매개변수명>: <매개변수 타입>, …): <반환 타입> {
//    // 함수 코드
// }
fun sayHello() {
    println("hello")
}

fun buildMessageFor(name: String, count: Int): String {
    return ("$name, you are customer number $count")
}

// 함수 호출
// <함수명> (<인자1>, <인자2>, …)
private fun example01() {
    sayHello()
    val msg = buildMessageFor("park", 5)
    println(msg)
}

// 지명 인자 named argument: 매개변수 이름을 지정하여 호출, 순서 변경가능
private fun example02() {
    val msg = buildMessageFor(count=5, name="park")
    println(msg)
}

// 매개변수 기본값 정의: 함수 호출시 생략된 매개변수의 기본값 지정
// 지명인자를 사용하지 않을 경우 첫 번째 매개변수를 생략하면 안된다
fun buildMessageForEx(name: String = "Customer", count: Int = 0): String {
    return ("$name, you are customer number $count")
}

private fun example03() {
    val msg = buildMessageForEx(count = 1)
    println(msg)
}

// 가변 인자 vararg: 함수 호출할 때 인자의 개수를 가변적으로 전달 가능
// 인자가 여러개인 경우 일반 인자를 먼저 선언하고 마지막에 가변 인자를 선언
fun displayString(vararg strs: String) {
    for (str in strs) print("$str "); println()
}

private fun example04() {
    displayString("one", "two", "three", "four")
}


// 단일 표현식 함수: 함수 실행 코드에 하나의 표현식만 있을 때
// fun <함수명> (<매개변수명>: <매개변수 타입>, …): <반환 타입> = // 함수 코드
fun multiply(x: Int, y: Int): Int {
    return x * y
}
fun multiply1(x: Int, y: Int): Int  = x * y
fun multiply2(x: Int, y: Int) = x * y      // 타입추론이 가능한 경우 반환타입 생략가능

// 지역 함수 local function: 다른 함수에 포함된 함수, 함수 호출 이전에 정의
//   자신을 포함하는 함수 외부의 다른 코드에서는 사용 불가
private fun example05() {
    val name = "Park"
    val count = 5

    fun displayString() {
        for (index in 0..count) println("$index $name")
    }

    displayString()
}



// 람다식: 독립적인 코드 블록
//   {<매개변수명>: <매개변수 타입>, … -> <값을 반환하는 표현식> }
private fun example06() {
    val sayHello = { println("Hello") }
    sayHello()

    val multiply = {x: Int, y: Int -> x * y}
    val result = multiply(10, 20)
    println(result)
}

// 람다식 처럼 일반 함수의 참조를 변수에 저장하고자 할 때
// 함수 이름 앞에 두 개의 콜론(::)을 붙이고 함수 괄호를 빼면 된다
private fun example07() {
    val buildMsg = ::buildMessageFor
    val msg = buildMsg("Park", 5)
    println(msg)
}

// 람다식의 끝에 인자를 포함하는 괄호를 추가하면 람다식이 선언과 동시에 바로 실행된다.
// 람다식에는 표현식 끝에 세미콜론(;)을 붙여 하나 이상의 표현식을 포함
// 람다식에서 중괄호 내부의 제일 마지막 표현식의 결과가 람다식의 결과로 반환된다.
private fun example08() {
    val result = {x: Int, y: Int -> x * y}(10, 20)
    println(result)

    val nextMsg = { println("hello"); "Goodbye"}()
    println(nextMsg)
}

// 고차 함수 higher-order function
//   람다식이나 함수의 참조를 다른 함수의 인자로 전달하거나 결과로 반환
// 함수 타입 function type 개념
//   매개변수와 반환 결과의 타입으로 정의
// 고차 함수의 매개변수 타입과 인자로 전달되는 함수의 결과 타입이 동일
private fun example09() {
    fun inchesToFeet(inches: Double): Double {
        return inches * 0.0833333
    }
    fun inchesToYard(inches: Double): Double {
        return inches * 0.0277778
    }
    fun outputConversion(converterFunc: (Double) -> Double, value: Double) {
        val result = converterFunc(value)
        println("Result of conversion is $result")
    }

    outputConversion(::inchesToFeet, 22.45)
    outputConversion(::inchesToYard, 22.45)


    fun decideFunc(feet: Boolean): (Double) -> Double {
        if (feet) {
            return ::inchesToFeet
        } else {
            return ::inchesToYard
        }
    }

    val converter = decideFunc(true)
    println( converter(22.45) )
}