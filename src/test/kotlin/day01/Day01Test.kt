package day01

import Utils
import kotlin.test.Test
import kotlin.test.assertEquals

class Day01Test {
    val testInput = Utils.readInput("day01.part1.txt")

    @Test
    fun testListAsNumbers() {
        val actualList: List<Pair<Int, Int>> = Day01.listAsNumbers(testInput)
        val expectedList: List<Pair<Int, Int>> = listOf(
            Pair(3, 4),
            Pair(4, 3),
            Pair(2, 5),
            Pair(1, 3),
            Pair(3, 9),
            Pair(3, 3),
        )
        assertEquals(expectedList, actualList)
    }

    @Test
    fun testPairsFromSortedLists() {
        val actualList: List<Pair<Int, Int>> = Day01.pairsFromSortedLists(testInput)
        val expectedList: List<Pair<Int, Int>> = listOf(
            Pair(1, 3),
            Pair(2, 3),
            Pair(3, 3),
            Pair(3, 4),
            Pair(3, 5),
            Pair(4, 9),
        )
        assertEquals(expectedList, actualList)
    }

    @Test
    fun testSumOfDistances() {
        val actualSum: Int = Day01.sumOfDistances(testInput)
        val expectedSum: Int = 11
        assertEquals(expectedSum, actualSum)
    }

    @Test
    fun day00Part1() {
        // test if implementation meets criteria from the description, like:
        assertEquals(2, Day01.part1(testInput))
    }

//    @Test
//    fun day00Part2() {
//        // test if implementation meets criteria from the description, like:
//        val testInput = Utils.readInput("day00.txt")
//        assertEquals(2, Day01.part2(testInput))
//    }
}
