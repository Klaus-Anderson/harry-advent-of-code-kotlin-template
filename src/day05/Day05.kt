package day05

import readInput
import java.util.*
import kotlin.NoSuchElementException
import kotlin.collections.ArrayDeque
import kotlin.collections.ArrayList

fun main() {
    fun part1(input: List<String>): String {
        val stacksIndexLine = input.first { line ->
            line.all {
                it.isDigit() or (it.toString() == " ")
            }
        }
        val stackList = input.take(
            input.indexOf(stacksIndexLine)
        ).map { line ->
            line.chunked(4).map { item ->
                item.filter {
                    it.isLetter()
                }
            }
        }.let { listListString ->
            ArrayList(List(stacksIndexLine.last {
                it.isDigit()
            }.toString().toInt()) { index ->
                ArrayDeque(listListString.map {
                    it[index]
                }.filterNot {
                    it == ""
                }.reversed())
            })
        }

        val instructionList = input.slice(
            input.indexOf(stacksIndexLine)+2 until input.size
        )
        instructionList.map { instruction ->
            val instructionNumbers = instruction.filter {
                it.isDigit() or (it.toString() == " ")
            }.also {
                it.replace("  ", " ")
            }.split(" ").filterNot {
                it == ""
            }.map {
                it.toInt()
            }
            val howManyToMove = instructionNumbers[0]
            val fromWhichStack = instructionNumbers[1] - 1
            val toWhichStack = instructionNumbers[2] - 1
            repeat(howManyToMove) {
                try {
                    stackList[toWhichStack].add(stackList[fromWhichStack].removeLast())
                } catch (_: NoSuchElementException){

                }
            }
        }
        return stackList.joinToString(separator = "") {
            it.removeLast()
        }
    }

    fun part2(input: List<String>): String {
        val stacksIndexLine = input.first { line ->
            line.all {
                it.isDigit() or (it.toString() == " ")
            }
        }
        val stackList = input.take(
            input.indexOf(stacksIndexLine)
        ).map { line ->
            line.chunked(4).map { item ->
                item.filter {
                    it.isLetter()
                }
            }
        }.let { listListString ->
            ArrayList(List(stacksIndexLine.last {
                it.isDigit()
            }.toString().toInt()) { index ->
                ArrayDeque(listListString.map {
                    it[index]
                }.filterNot {
                    it == ""
                }.reversed())
            })
        }

        val instructionList = input.slice(
            input.indexOf(stacksIndexLine)+2 until input.size
        )
        instructionList.map { instruction ->
            val instructionNumbers = instruction.filter {
                it.isDigit() or (it.toString() == " ")
            }.also {
                it.replace("  ", " ")
            }.split(" ").filterNot {
                it == ""
            }.map {
                it.toInt()
            }
            val howManyToMove = instructionNumbers[0]
            val fromWhichStack = instructionNumbers[1] - 1
            val toWhichStack = instructionNumbers[2] - 1
            val toAdd = mutableListOf<String>()
            repeat(howManyToMove) {
                try {
                    toAdd.add(stackList[fromWhichStack].removeLast())
                } catch (_: NoSuchElementException){

                }
            }
            toAdd.reversed().forEach {
                stackList[toWhichStack].add(it)
            }
        }
        return stackList.joinToString(separator = "") {
            it.removeLast()
        }
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("day05", "Day05_test")
    check(part1(testInput) == "CMZ")
    check(part2(testInput) == "MCD")

    val input = readInput("day05", "day05")
    println(part1(input))
    println(part2(input))
}
