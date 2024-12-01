package day01

import Utils
import println
import kotlin.math.absoluteValue

fun main() {
    val day01Input = Utils.readInput("day01.part1.txt")
    val part1Result = Day01.part1(day01Input)
    part1Result.println()
//
//    val part2Result = Day01.part2(day01Input)
//    part2Result.println()
}

object Day01 {
    fun listAsNumbers(input: List<String>): List<Pair<Int, Int>> {
        return input.map { line ->
            line.replace("   ", " ").replace("  ", " ")
                .split(' ')
                .map { it.toInt() }
        }.map { Pair(it[0], it[1]) }
    }

    fun pairsFromSortedLists(input: List<String>): List<Pair<Int, Int>> {
        val rawNumbers: List<Pair<Int, Int>> = listAsNumbers(input)
        val leftList: MutableList<Int> = mutableListOf<Int>()
        val rightList: MutableList<Int> = mutableListOf<Int>()

        rawNumbers.forEach {
            leftList.add(it.first);
            rightList.add(it.second)
        }

        leftList.sort()
        rightList.sort()

        return List(leftList.size) { index ->
            Pair(leftList[index], rightList[index])
        }
    }

    fun sumOfDistances(input: List<String>): Int {
        val pairsFromSortedLists = pairsFromSortedLists(input)
        pairsFromSortedLists.forEach { println("$it -> ${it.diff()}") }
        return pairsFromSortedLists.sumOf { it.diff() };
    }

    fun part1(lines: List<String>): Int {
        return sumOfDistances(lines)
    }

//
//    fun part2(lines: List<String>): Int {
//        return lines.size
//    }
}

/**
 * Calculate the diff between a pair of Ints
 */
fun Pair<Int, Int>.diff() = (this.first - this.second).absoluteValue
