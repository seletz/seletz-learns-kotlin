package com.nexiles.example.seletz_learns_kotlin


fun main() {

    // Blocks: Lambdas as last argument, move closing `)` before block:
    fun thatBlock( foo: Int, block: (number : Int) -> Int): Int {
        println("thatBlock: foo=$foo")
        return block(foo * 2)
    }

    val n = 5
    val result = thatBlock(n) {N ->
        println("block: it=$N")
        N * 2
    }
    println("thatBlock($n) -> $result")

    // Lambdas
    val l = { x : Int -> x * 2}
    l(3)

    // HOF
    val items = listOf(1, 2, 3, 4)
    val r = items.fold(0) {
        acc : Int, i : Int ->
        acc + i
    }

    println("fold(1..4, {...}) -> $r")


    val r2 = items.fold(0, Int::plus)

    println("fold(1..4, +) -> $r2")

    // Function Types
    val f : (Int, Int) -> Double = { x, y -> x.div(y).toDouble() }

    // FT with a **receiver** type
    val tagifiy : String.() -> String = { "<$this>"}
    val tagged = "hello".tagifiy()

    println("\"hello\".tagify() -> $tagged")
}
