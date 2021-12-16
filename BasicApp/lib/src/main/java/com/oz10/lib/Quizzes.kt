package com.oz10.lib

fun main(args: Array<String>) {
    println("Quizzes")

    println("윤년 맞추기..")
    checkLeapYear(1700)  // 1700 X

    println("369게임..")
    game369()
    game369Ex(99)
}

fun game369() {
    // 0부 99까지 369게임
    //    30*
    //    31*
    //    32*
    //    33**
    // 0~99
    // 1의 자리 10의 자리
    // 3, 6, 9 비교
    // * (박수)
    for (cnt in 0..99) {
        val a = cnt / 10 // 10의 자리
        val b = cnt % 10 // 1의 자리
        print("" + a + b)
        if (a % 3 == 0 && a != 0) print("*") // 10의 자리 3, 6, 9 비교 * (박수)
        if (b % 3 == 0 && b != 0) print("*") // 1의 자리 3, 6, 9 비교 * (박수)
        println()
    }

}

fun game369Ex(cnt: Int) {
    for (cnt in 0..cnt) {
        println(cnt.toString() + is369(cnt))
    }
}

fun is369(cnt: Int): String {
    val a = cnt / 10
    val b = cnt % 10
    val str = if (b % 3 == 0 && b != 0) "*" else ""
    return if (a == 0) str else str + is369(a)
}

fun checkLeapYear(year: Int) {
    // 윤년 맞추기
    // 1700, 2016, 2020, 1900, 2400, 2100, 2019
    if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0)
        println("$year O")
    else
        println("$year X")
}
