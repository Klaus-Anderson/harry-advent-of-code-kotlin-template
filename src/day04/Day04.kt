package day04

import readInput

fun main() {

    fun parseElfSection(it: String): List<Int> {
        return it.split("-").let {
            (it[0].toInt() until it[1].toInt() + 1).toList()
        }
    }

    fun part1(input: List<String>): Int {
        return input.map {
            it.split(",")
        }.sumOf {
            val elfString0 = it[0]
            val elfString1 = it[1]
            val elfSections0 = parseElfSection(elfString0)
            val elfSections1 = parseElfSection(elfString1)
            if (elfSections0.containsAll(elfSections1) || elfSections1.containsAll(elfSections0)) {
                1
            } else {
                0
            }.toInt()
        }
    }

    fun part2(input: List<String>): Int {
        return input.map {
            it.split(",")
        }.sumOf {
            val elfString0 = it[0]
            val elfString1 = it[1]
            val elfSections0 = parseElfSection(elfString0)
            val elfSections1 = parseElfSection(elfString1)
            if (elfSections0.intersect(elfSections1.toSet()).isNotEmpty()) {
                1
            } else {
                0
            }.toInt()
        }
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("day04", "Day04_test")
    check(part1(testInput) == 2)
    check(part2(testInput) == 4)

    val input = readInput("day04", "Day04")
    println(part1(input))
    println(part2(input))
}
