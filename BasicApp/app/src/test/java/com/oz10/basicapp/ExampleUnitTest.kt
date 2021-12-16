package com.oz10.basicapp

import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun testLeapYear() {
        assertEquals(true, isLeapYear(2020))
        assertEquals(false, isLeapYear(1900))
        assertEquals(true, isLeapYear(2400))
    }

    private fun isLeapYear(year: Int): Boolean {
        if (year % 400 == 0) return true
        if (year % 100 == 0) return false
        return year % 4 == 0
    }

    @Test
    fun testPibo() {
        // 0 1 1 2 3 5 8 13 21 ...
        // 0 1 2 3 4 5 6 7  8 ...
        assertEquals(0, pibo(0))
        assertEquals(1, pibo(1))
        assertEquals(1, pibo(2))
        assertEquals(2, pibo(3))
        assertEquals(3, pibo(4))
        assertEquals(5, pibo(5))
    }

    private fun pibo(n: Int): Int {
        if (n == 0) return 0
        if (n <= 2) return 1
        return pibo(n - 2) + pibo(n - 1)
    }
}