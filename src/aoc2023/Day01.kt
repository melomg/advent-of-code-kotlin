package aoc2023

import println

fun main() {
    fun part1(input: List<String>): Int = input.sumOf { line ->
        val chars = line.toCharArray()
        val first = chars.first { it.isDigit() }.digitToInt()
        val last = chars.last { it.isDigit() }.digitToInt()
        first * 10 + last
    }

    fun part2(input: List<String>): Int {
        val map = mapOf(
            "one" to 1,
            "1" to 1,
            "two" to 2,
            "2" to 2,
            "three" to 3,
            "3" to 3,
            "four" to 4,
            "4" to 4,
            "five" to 5,
            "5" to 5,
            "six" to 6,
            "6" to 6,
            "seven" to 7,
            "7" to 7,
            "eight" to 8,
            "8" to 8,
            "nine" to 9,
            "9" to 9
        )

        return input.sumOf { line ->
            val first = map.entries
                .map { (key, value) -> line.indexOf(key) to value }
                .filter { it.first >= 0 }
                .minBy { it.first }
                .second
            val last = map.entries
                .map { (key, value) -> line.lastIndexOf(key) to value }
                .filter { it.first >= 0 }
                .maxBy { it.first }
                .second
            first * 10 + last
        }
    }

    // TEST
    val testPart1 = readInputFor23("Day01_part1_test")
    check(part1(testPart1) == 142)
    val testPart2 = readInputFor23("Day01_part2_test")
    check(part2(testPart2) == 281)

    // AOC
    val input = readInputFor23("Day01")
    part1(input).println()
    part2(input).println()
}
