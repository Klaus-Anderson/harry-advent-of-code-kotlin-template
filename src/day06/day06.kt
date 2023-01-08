package day06

import readInput

fun main() {
    fun part1(input: List<String>): Int {

        input.first().let { inputString ->
            inputString.forEachIndexed { index, char ->
                val list = List(4) {
                    inputString[index + it]
                }
                if (list.all {
                        list.indexOf(it) ==
                                list.lastIndexOf(it)
                    })
                    return index + 4
            }
        }
        return 0
    }

    fun part2(input: List<String>): Int {
        input.first().let { inputString ->
            inputString.forEachIndexed { index, char ->
                val list = List(14) {
                    inputString[index + it]
                }
                if (list.all {
                        list.indexOf(it) ==
                                list.lastIndexOf(it)
                    })
                    return index + 14
            }
        }
        return 0
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("day06", "Day06_test")
    check(part1(testInput) == 7)
    check(part2(testInput) == 19)
//
    val input = readInput("day06", "day06")
    println(part1(input))
    println(part2(input))
}
