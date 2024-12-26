package day02

import Utils
import println
import kotlin.math.absoluteValue

fun main() {
    val day01Input = Utils.readInput("day02.part1.txt")
    val part1Result = Day02.part1(day01Input)
    part1Result.println()

    val part2Result = Day02.part2(day01Input)
    part2Result.println()
}

object Day02 {
    fun part1(lines: List<String>): Int {
        val reports: List<Report> = lines.map { Report.create(it) }
        val countOfSafeReport = reports.count { it.isSafe() }
        return countOfSafeReport
    }


    fun part2(lines: List<String>): Int {
        val reports: List<Report> = lines.map { Report.create(it) }
        val countOfSafeReport = reports.count { it.isSafeWithProblemDumper() }
        return countOfSafeReport
    }
}

class Report(private val levels: List<Int>) {
    companion object {
        fun create(levelStr: String): Report {
            val intList = levelStr.split(" ").map { it.toInt() }
            return Report(intList)
        }
    }

    fun isSafe(): Boolean {
        var allIncreasing: Boolean = true
        var allDecreasing: Boolean = true
        val levelsIterator = this.levels.listIterator()
        while (levelsIterator.hasNext()) {
            val currentLevel = levelsIterator.next()
            val diff: Int
            if (levelsIterator.hasNext()) {
                diff = (currentLevel - this.levels[levelsIterator.nextIndex()])
            } else {
                continue
            }

            if (diff.absoluteValue < 1 || diff.absoluteValue > 3) {
                //if diff < 1 or > 3
                return false
            }
            allIncreasing = allIncreasing && diff < 0
            allDecreasing = allDecreasing && diff > 0
            if (!allIncreasing && !allDecreasing) {
                //if not increasing or either decreasing, return false
                return false
            }
        }
        return true
    }

    fun isSafeWithProblemDumper(): Boolean {
        if (this.isSafe()) {
            return true
        }
        for (i in this.levels.indices) {
            val levelsWithoutElementAtI = this.levels.toMutableList()
            levelsWithoutElementAtI.removeAt(i)
            val isSafeWithoutElementAtI = Report(levelsWithoutElementAtI).isSafe()
            if (isSafeWithoutElementAtI) {
                return true
            }
        }
        return false
    }

    override fun toString(): String {
        return this.levels.toString()
    }
}
