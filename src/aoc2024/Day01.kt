package aoc2024

import kotlin.math.absoluteValue

fun main() {

    fun part1(first: List<Int>, second: List<Int>): Int =
        first
            .sorted()
            .zip(second.sorted())
            .fold(0) { acc, pair ->
                acc + (pair.first - pair.second).absoluteValue
            }

    fun part2(first: List<Int>, second: List<Int>): Int =
        first.fold(0) { acc: Int, targetNumber: Int ->
            acc + targetNumber * second.count { it == targetNumber }
        }

    // TEST PART 1
    val (testFirst, testSecond) = readInputFor24("Day01_part1_test").map {
        val lineNumbers = it.split("   ")
        Pair(lineNumbers[0].toInt(), lineNumbers[1].toInt())
    }.unzip()
    check(part1(testFirst, testSecond) == 11)

    // REAL PART 1
    val (firstList, secondList) = readInputFor24("Day01").map {
        val lineNumbers = it.split("   ")
        Pair(lineNumbers[0].toInt(), lineNumbers[1].toInt())
    }.unzip()
    val part1Result = part1(firstList, secondList)
    println("part1 result = $part1Result")

    // TEST PART 2
    check(part2(testFirst, testSecond) == 31)

    // REAL PART 2
    val part2Result = part2(firstList, secondList)
    println("part2 result = $part2Result")
}
