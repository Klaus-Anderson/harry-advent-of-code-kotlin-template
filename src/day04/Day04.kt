package day04

import readInput

fun main() {

    fun part1(input: List<String>): Int {
        return input.sumOf { bagString ->
            val comp1 = bagString.substring(0, bagString.length / 2)
            val comp2 = bagString.substring(bagString.length / 2, bagString.length)

            val commonLetters = comp1.filter {
                comp2.contains(it)
            }.toSet().toList()
            commonLetters.sumOf {
                it.convertToScore()
            }
        }
    }

    fun part2(input: List<String>): Int {
        return List(input.size) { index ->
            if (index.mod(3) == 0) {
                val bag1 = input[index]
                val bag2 = input[index + 1]
                val bag3 = input[index + 2]
                bag1.first {
                    bag2.contains(it) && bag3.contains(it)
                }.convertToScore()
            } else {
                0
            }
        }.sum()
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("day03", "Day03_test")
    check(part1(testInput) == 157)
//    check(part2(testInput) == 12)

    val input = readInput("day03", "Day03")
    println(part1(input))
    println(part2(input))
}

private fun Char.convertToScore(): Int {
    return this.lowercase()[0] - 'a' + 1 + if (this.isUpperCase()) {
        26
    } else {
        0
    }
}
