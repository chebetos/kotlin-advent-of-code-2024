package day07

import day01.Day01
import kotlin.test.Test
import kotlin.test.assertEquals

class Day07Test {
    @Test
    fun day07Part1() {
        // test if implementation meets criteria from the description, like:
        val testInput = Utils.readInput("Day07_part1_test.input")
        assertEquals(6440, Day07.part1(testInput))
    }

}