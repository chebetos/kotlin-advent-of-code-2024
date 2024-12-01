package day01

import Utils
import day00.Day00
import kotlin.test.Test
import kotlin.test.assertEquals

class Day00Test {

    @Test
    fun day00Part1() {
        // test if implementation meets criteria from the description, like:
        val testInput = Utils.readInput("day00.txt")
        assertEquals(2, Day00.part1(testInput))
    }

    @Test
    fun day00Part2() {
        // test if implementation meets criteria from the description, like:
        val testInput = Utils.readInput("day00.txt")
        assertEquals(2, Day00.part2(testInput))
    }
}
