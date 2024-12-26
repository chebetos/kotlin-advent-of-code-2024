package day01

import Utils
import println
import kotlin.math.absoluteValue

fun main() {
    val day01Input = Utils.readInput("day01.part1.txt")
    val part1Result = Day01.part1(day01Input)
    part1Result.println()

    val part2Result = Day01.part2(day01Input)
    part2Result.println()
}

object Day01 {
    fun listAsNumbers(input: List<String>): List<Pair<Int, Int>> {
        return input.map { line ->
            line.replace("   ", " ").replace("  ", " ")
                .split(' ')
                .map { it.toInt() }
        }.map { Pair(it[0], it[1]) }
    }

    private fun sortedLists(input: List<String>): Pair<List<Int>, List<Int>> {
        val rawNumbers: List<Pair<Int, Int>> = listAsNumbers(input)
        val leftList: MutableList<Int> = mutableListOf()
        val rightList: MutableList<Int> = mutableListOf()

        rawNumbers.forEach {
            leftList.add(it.first)
            rightList.add(it.second)
        }

        leftList.sort()
        rightList.sort()
        return Pair(leftList, rightList)
    }

    fun pairsFromSortedLists(input: List<String>): List<Pair<Int, Int>> {
        val (leftList: List<Int>, rightList: List<Int>) = sortedLists(input)

        return List(leftList.size) { index ->
            Pair(leftList[index], rightList[index])
        }
    }

    fun sumOfDistances(input: List<String>): Int {
        val pairsFromSortedLists = pairsFromSortedLists(input)
        pairsFromSortedLists.forEach { println("$it -> ${it.diff()}") }
        return pairsFromSortedLists.sumOf { it.diff() }
    }

    fun countFrequencies(input: List<String>): Pair<List<Int>, Map<Int, Int>> {
        val sortedLists: Pair<List<Int>, List<Int>> = sortedLists(input)
        val counts = mutableMapOf<Int, Int>()
        sortedLists.first.toSet().forEach { leftValue ->
            counts[leftValue] = sortedLists.second.count { rightValue -> rightValue == leftValue }
        }

        return Pair(sortedLists.first, counts)
    }

    fun similarityScore(input: List<String>): Int {
        val (leftList: List<Int>, countByNumber: Map<Int,Int>) = countFrequencies(input)
        return leftList.sumOf { it * countByNumber.getOrDefault(it, 0) }
    }

    fun part1(lines: List<String>): Int {
        return sumOfDistances(lines)
    }


    fun part2(lines: List<String>): Int {
        return similarityScore(lines)
    }
}

/**
 * Calculate the diff between a pair of Ints
 */
fun Pair<Int, Int>.diff() = (this.first - this.second).absoluteValue
