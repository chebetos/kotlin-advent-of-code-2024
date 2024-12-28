package day03

import Utils
import println

fun main() {
    val part1Input = Utils.readInputAsString("day03.part1.txt")
    val part1Result = Day03.part1(part1Input)
    part1Result.println()

    val part2Result = Day03.part2(part1Input)
    part2Result.println()
}

object Day03 {
    fun part1(input: String): Int {
        val mulInstructionsRegExp = Regex("(mul\\([\\d]{1,3},[\\d]{1,3}\\))")
        val numberRegExp = Regex("(\\d+)")
        val operations = mulInstructionsRegExp.findAll(input)
            .map {
                val numbers = numberRegExp.findAll(it.value)
                    .map { number -> Integer.valueOf(number.value) }
                    .toList()
                Pair(numbers[0], numbers[1])
            }

        val multiplyResults = operations.map { it.multiply() }
        return multiplyResults.sum()
    }


    fun part2(input: String): Int {
        val cleanedMemory = cleanMemoryContent(input)
        return part1(cleanedMemory)
    }

    private fun cleanMemoryContent(input: String): String {
        val memoryContent = StringBuilder(input)
        while (true) {
            val indexOfDont = memoryContent.indexOf("don't()")
            if (indexOfDont == -1) {
                break
            }

            val doCommand = "do()"

            var indexOfDo = memoryContent.indexOf(doCommand, indexOfDont)
            if (indexOfDo == -1) {
                indexOfDo = memoryContent.length
            } else if (indexOfDo + doCommand.length >= memoryContent.length) {
                indexOfDo = memoryContent.length
            } else {
                indexOfDo += doCommand.length
            }
            memoryContent.delete(indexOfDont, indexOfDo)
        }
        return memoryContent.toString()
    }
}

fun Pair<Int, Int>.multiply() = (this.first * this.second)
