package com.oz10.lib

// 코틀린 컬렉션 collection
// List, Set, Map

// List
//   각 요소값이 순차적으로 저장되며, 중복값을 허용
//   listOf 함수를 사용, 읽기 전용 List 를 반환
//   mutableListOf 함수 사용, 변경 가능 List 를 반환
//     변경자 함수 mutator function : 변경 가능 List 요소를 변경하는 함수들
fun listCollection() {
    val list: List<String> = listOf("one", "two", "three") // 읽기 전용 List
    println(list)
    println(list[0])    // List 요소 사용하기
    println(list.first())
    println(list.last())
    println(list.getOrElse(2) { "Unknown" })  // 안전한 인덱스 사용 함수
    println(list.getOrElse(3) { "Unknown" })
    println(list.getOrNull(3) ?: "Unknown")
    println(list.contains("one"))   // 요소가 있는지 검사
    println(list.containsAll(listOf("one", "four")))   // 여러 요소가 있는지 검사

    val mlist = mutableListOf("one", "two", "three")    // 변경 가능 List
    println(mlist.remove("one")); println(mlist)
    mlist.add("four"); println(mlist)
    mlist.add(0, "one"); println(mlist)
    mlist[0] = "1"; println(mlist)  // 인덱스 연산자를 사용해서 요소 변경

    mlist.addAll(listOf("Eli", "Alex")); println(mlist)
    mlist -= listOf("Eli", "Alex"); println(mlist)
    mlist += listOf("Eli", "Alex"); println(mlist)

    // 람다에 지정된 조건식을 기반으로 List 요소들을 삭제
    mlist.removeIf { it.contains("o") }; println(mlist)
    val readOnlyList = mlist.toList()   // 읽기 전용으로 변경
    mlist.clear(); println(mlist)

    // 반복 처리
    for (p in list) print("$p.. "); println()
    list.forEach { p -> print("$p.. ") }; println()
    list.forEachIndexed { index, p -> print("$index=$p.. ") }; println()

    // 요소 섞기
    print("shuffled : ")
    println(list.shuffled().first())

    // 해체 destructure
    val (a, b, c) = list    // 요소들을 분리
    println("$a, $b, $c")
    val (d, _, e) = list    // 해체를 원하지 않는 요소에 밑줄 기호를 사용
    println("$d, $e")
}

// Set
//   집합의 개념을 나타내므로 중복되지 않는 값을 갖는 요소들로 저장
//   setOf 함수를 사용, 읽기 전용 Set 를 반환
//   mutableSetOf 함수 사용, 변경 가능 Set 를 반환
//     변경자 함수 mutator function : 변경 가능 Set 요소를 변경하는 함수들
fun setCollection() {
    val set = setOf("one", "two", "three", "one") // 읽기 전용 Set
    println(set)
    println(set.contains("one"))    // 요소가 있는지 확인
    println(set.contains("four"))
    println(set.elementAt(2))   // 인덱스 2의 요소

    val mset = mutableSetOf("one", "two", "three")
    mset.add("4"); println(mset)
    mset.addAll(listOf("5", "6", "7")); println(mset)
    mset -= listOf("5", "6", "7"); println(mset)
    mset += listOf("5", "6", "7"); println(mset)
    mset.removeAll(listOf("5", "6", "7")); println(mset)
    mset.remove("4"); println(mset)

    // 반복 처리
    for (p in set) print("$p.. "); println()

    mset.clear(); println(mset)

    // List -> Set
    println( listOf("one", "two", "three", "one").toSet() )
    // List -> Set -> List
    println( listOf("one", "two", "three", "one").toSet().toList() )
}

// Map
//   키 key 와 이 키에 대응되는 값 value 의 쌍으로 저장
//   항목 entry : 키와 값의 쌍으로 저장된 데이터
//   mapOf 함수를 사용, 읽기 전용 Map 를 반환
//   mutableMapOf 함수 사용, 변경 가능 Map 를 반환
//     변경자 함수 mutator function : 변경 가능 Map 요소를 변경하는 함수들
fun mapCollection() {
    val map = mapOf("one" to 1.0, "two" to 2.0, "three" to 3.0) // 읽기 전용 Map 생성
    val a = mapOf(Pair("one", 1.0),
                    Pair("two", 2.0),
                    Pair("three", 3.0)
    )
    println(map)
    println(a)

    val mmap = mutableMapOf("one" to 1.0, "two" to 2.0, "three" to 3.0) // 변경 가능 Map
    println(mmap["one"])
    println(mmap.getValue("one"))
    println(mmap.getOrElse("1") {"No search"} )
    println(mmap.getOrDefault("1", 0) )

    mmap += "four" to 4.0 ; println(mmap)
    mmap += "four" to 5.0 ; println(mmap)   // 중복된 키는 값 업데이트
    mmap -= "four" ; println(mmap)
    mmap["1"] = 1.0 ; println(mmap)
    mmap["1"] = 2.0 ; println(mmap)  // 중복된 키는 값 업데이트
    mmap.put("2", 2.0); println(mmap)
    mmap.putAll( listOf("3" to 3.0, "4" to 4.0) ) ; println(mmap)

    // 반복 처리
    mmap.forEach { (k, v) -> print("$k=$v.. ") } ; println()

    // 키가 없으면 항목을 추가하고, 있으면 기존 값을 반환
    println( mmap.getOrPut("5") {5.0} ) ; println(mmap)
    println( mmap.getOrPut("5") {10.0} ) ; println(mmap)

    // 지정한 키의 항목을 제외한 새로운 Map 을 반환
    val b = mmap - "5"
    println("b -> $b"); println("mmap -> $mmap")

    mmap.clear(); println(mmap)
}

fun main(args: Array<String>) {
    listCollection()
    setCollection()
    mapCollection()
}