package day00

import Utils
import println

fun main() {
    val day01Input = Utils.readInput("day00_input.txt")
    val part1Result = Day00.part1(day01Input)
    part1Result.println()

    val part2Result = Day00.part2(day01Input)
    part2Result.println()
}

object Day00 {
    fun part1(lines: List<String>): Int {
        return lines.size
    }

    fun part2(lines: List<String>): Int {
        return lines.size
    }
}
