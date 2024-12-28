package day03

import Utils
import kotlin.test.Test
import kotlin.test.assertEquals

class Day03Test {
    @Test
    fun testPart1() {
        val testInput = Utils.readInputAsString("day03.part1.txt")
        val sumOfMultiplications: Int = Day03.part1(testInput)
        assertEquals(161, sumOfMultiplications)
    }

    @Test
    fun testPart2() {
        val testInput = Utils.readInputAsString("day03.part2.txt")
        val sumOfMultiplications: Int = Day03.part2(testInput)
        assertEquals(48, sumOfMultiplications)
    }
}
