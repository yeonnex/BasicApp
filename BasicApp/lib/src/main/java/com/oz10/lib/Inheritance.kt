package com.oz10.lib

// 코틀린 클래스 상속과 서브 클래스
// 상속과 서브 클래스 개요
//   코틀린의 모든 클래스는 기본적으로 Any 라는 클래스의 파생(상속) 클래스가 된다
//   Any 클래스는 모든 클래스의 기반이 되는 속성과 함수를 제공한다
//   파생(상속) 클래스를 생성하면 클래스 간의 계층 구조가 형성
//     베이스 base  / 루트 root 클래스 : 계층 구조의 제일 최상위 클래스
//     서브 sub    / 자식 child 클래스 : 파생(상속)된 클래스
//     부모 parent / 슈퍼 super 클래스 : 서브 클래스의 바로 위 계층 클래스
//   코틀린은 다중 상속 multiple inheritance 를 지원하지 않는다
//     바로 위 계층의 부모 클래스는 하나만 될 수 있다

// 서브 클래스 생성
//   open class ParentClass { … }
//   class SubClass : ParentClass() { … }
//   클래스 상속 관련 코드의 오류나 착오 방지를 위해 부모 클래스에 open 키워드 사용
// 기본 생성자를 갖는 클래스의 경우 서브 클래스에 부모 클래스의 기본 생성자를 참조하도록 서브 클래스를 선언
//   open class ParentClass(var x: Int) { … }
//   class SubClass(x: Int) : ParentClass(x) { … }

// 하나 이상의 보조 생성자를 갖는 클래스의 경우
//   서브 클래스 선언에서도 보조 생성자를 구현하고
//   super 키워드를 사용해서 부모 클래스의 보조 생성자를 호출

open class ParentClass {
    var x: Int = 0
    constructor(num: Int) {
        x = num
    }
}
class SubClass : ParentClass {
    constructor(num: Int) : super(num) {
        // 서브 클래스 생성자에서 실행할 코드
    }
}


// 부모(상위) 클래스
open class BankAccountP {
    var accountNumber: Int = 0
    var accountBalance: Double = 0.0

    constructor(number: Int, balance: Double) {
        accountNumber = number
        accountBalance = balance
    }

    // 계좌 잔액을 출력하는 함수
    open fun displayBalance() {
        println("Number $accountNumber")
        println("Current balance is $accountBalance")
    }
}

// 서브 클래스 기능 확장
// 상속받은 함수 오버라이딩
//   상속받은 함수의 새로운 버전을 작성:
//     함수 시그니처(함수명, 매개변수의 개수 및 타입, 반환 타입)는 동일하게 하면서 함수 몸체의 실행 코드만 다르게 작성
//   부모 클래스의 오버라이딩되는 함수에 open 키워드를 지정하고, 서브 클래스의 오버라이딩 함수에는 override 키워드를 지정
//   서브 클래스의 오버라이딩한 함수에서 부모 클래스의 오버라이딩된 함수를 호출하고자 할 때는 super 키워드를 사용

class SavingsAccount : BankAccountP {
    constructor(number: Int, balance: Double) : super(number, balance)
    constructor(number: Int, balance: Double, rate: Double) : super(number, balance) {
        this.rate = rate
    }

    // 이자율과 이자금액 산출 함수
    var rate: Double = 0.02
    fun calculateInterest(): Double {
        return rate * accountBalance
    }

    override fun displayBalance() {
        super.displayBalance()
        println("Interest rate is $rate")
    }
}

fun main(args: Array<String>) {
    val sc = SubClass(0)
    println( sc.x )
    sc.x = 1
    println( sc.x )

    val sa = SavingsAccount(12345, 1000.0)
    println( sa.calculateInterest() )
    sa.displayBalance()

    val sa2 = SavingsAccount(12346, 1000.0, 0.07)
    println( sa2.calculateInterest() )
    sa2.displayBalance()
}