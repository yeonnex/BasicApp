package com.oz10.lib

// 코틀린 흐름 제어 flow control - 하나 이상의 조건에 기반하여 실행할 코드와 횟수를 결정

fun main(args: Array<String>) {
    println("Flow Control")

    // 루프 흐름 제어
    example01()
    example02()
    example03()
    example04()

    // 조건 흐름 제어
    example05()
    example06()
    example07()
}

// 루프 흐름 제어: 루프는 지정된 조건이 충족되는 동안 반복 실행되는 코드

// for-in 문: 컬렉션 collection 이나 숫자 범위에 포함된 항목을 반복 처리하는 데 사용
// for (변수명 in '컬렉션이나 범위') { //실행될 코드 }
//    downTo: 지정된 컬렉션을 거꾸로 반복 처리
//    until: 지정된 컬렉션을 처음부터 반복 처리
//    until step: 매 반복마다 증가될 값을 지정
private fun example01() {
    for (index in 1..5) {
        println(index)
    }

    for (index in "Hello") print("$index.. "); println()
    for (index in 100 downTo 90) print("$index.. "); println()
    for (index in 1 until 10) print("$index.. "); println()
    for (index in 0 until 100 step 10) print("$index.. "); println()
}

// while 문: 반복 처리 횟수는 모르고 특정 조건을 충족할 때까지 반복 처리
// while (조건식) { //실행 코드 }
private fun example02() {
    var cnt = 0
    while (cnt < 10) {
        print("$cnt.. ")
        cnt++;
    }
    println()

    cnt = 0
    while (cnt < 10) print("${cnt++}.. "); println()
}

// do … while 문: 루프 내부의 코드를 먼저 실행한 후 조건을 검사(최소1회)
// do { //실행 코드 } while (조건식)
private fun example03() {
    var cnt = 10
    do {
        print("$cnt.. ")
        cnt--;
    } while (cnt > 0)
    println()

    cnt = 10
    do print("${cnt--}.. ") while (cnt > 0); println()
}

// 루프 벗어나기
//   break 현재 루프를 벗어나서 루프 바로 다음에 있는 코드를 실행
//   continue 루프 내부의 나머지 코드는 실행하지 않고 루프의 처음으로 돌아가서 다음 반복을 계속 실행
//   라벨명@ 를 사용해서 표현식 앞에 라벨을 붙이고 break와 continue 문에서 참조
//     break@라벨명
private fun example04() {
    var cnt = 10
    for (i in 0..20) {
        cnt++
        if (cnt > 20)
            break
        print("$cnt.. ")
    }
    println()

    cnt = 1
    while (cnt < 20) {
        cnt++
        if (cnt % 2 != 0)
            continue
        print("$cnt.. ")
    }
    println()

    outerloop@
    for (i in 1..100) {
        println("i -> $i")
        for (j in 1..100) {
            print("$j.. ")
            if (j == 10) break@outerloop
        }
    }
    println()
}


// 조건 흐름 제어: 하나 이상의 조건에 따라 코드를 다르게 실행

// if 표현식: 실행 되는 한 줄일 때는 열고 닫는 중괄호({})를 생략 가능
// if (조건식) { // 조건식의 결과가 true일 때 실행될 코드 }
// 코틀린에서 if는 기존 프로그래밍 언어와 다르게 true나 false를 값으로 반환하므로 다른 표현식 안에 사용할 수 있다.
//   명령문이면서 표현식이다.
//   변수 = if (조건식) 반환값1 else 반환값2
private fun example05() {
    val x = 10
    if (x > 9) println("x is greater than 9")

    val y = if (x > 9) x else 9
    println(y)
}

// if … else … 표현식
//   if (조건식) { // if 표현식의 결과가 true일 때 실행될 코드 }
//   else { // if 표현식의 결과가 false일 때 실행될 코드 }
// if … else if … 표현식: 여러 가지 조건에 따라 코드 실행을 결정할 경우
private fun example06() {
    val x = 10
    if (x > 9) println("x is greater than 9")
    else println("x is less than 9")

    if (x == 10) println("x is 10")
    else if (x == 9) println("x is 9")
    else if (x == 8) println("x is 8")
    else println("x is less than 8")
}

// when 표현식: 검사할 조건이 많을 때 사용하면 편리
// 자바의 switch-case 와 유사
// when (value) {
//    match1 -> // 값이 일치될 때 실행될 코드
//    match2 -> // 값이 일치될 때 실행될 코드
//    …
//    else -> // 모든 값이 일치되지 않을 때 실행될 코드
// }
private fun example07() {
    val x = 9
    when (x) {
        10 -> println("x is 10")
        9 -> println("x is 9")
        8 -> println("x is 8")
        else -> println("x is less than 8")
    }
}

