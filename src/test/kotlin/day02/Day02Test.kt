package day02

import Utils
import kotlin.test.Test
import kotlin.test.assertEquals

class Day02Test {
    private val testInput = Utils.readInput("day02.part1.txt")

    @Test
    fun testCountOfSafeReports() {
        val countOfSafeReports: Int = Day02.part1(testInput)
        assertEquals(2, countOfSafeReports)
    }

    @Test
    fun testCountOfSafeReportsWithProblemDumper() {
        val countOfSafeReports: Int = Day02.part2(testInput)
        assertEquals(4, countOfSafeReports)
    }
}
