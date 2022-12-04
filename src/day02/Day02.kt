package day02

import readInput
import java.rmi.UnexpectedException
import java.util.*

fun main() {

    fun part1(input: List<String>): Int {
        return input.sumOf { string ->
            returnHumanPlayerMatchOutCome(string[0].toRpsMove(), string[2].toRpsMove())
        }
    }

    fun part2(input: List<String>): Int {
        return input.sumOf { string ->
            val elfPlayerMove = string[0].toRpsMove()
            returnHumanPlayerMatchOutCome(elfPlayerMove, string[2].getHumanMove(elfPlayerMove))
        }
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("day02", "Day02_test")
    check(part1(testInput) == 15)
    check(part2(testInput) == 12)

    val input = readInput("day02", "Day02")
    println(part1(input))
    println(part2(input))
}

private fun Char.getHumanMove(elfPlayerMove: RpsMove): RpsMove {
    return when (this.toString().lowercase()) {
        "x" -> when (elfPlayerMove) {
            RpsMove.ROCK -> RpsMove.SCISSORS
            RpsMove.PAPER -> RpsMove.ROCK
            RpsMove.SCISSORS -> RpsMove.PAPER
        }
        "y" -> when (elfPlayerMove) {
            RpsMove.ROCK -> RpsMove.ROCK
            RpsMove.PAPER -> RpsMove.PAPER
            RpsMove.SCISSORS -> RpsMove.SCISSORS
        }
        "z" -> when (elfPlayerMove) {
            RpsMove.ROCK -> RpsMove.PAPER
            RpsMove.PAPER -> RpsMove.SCISSORS
            RpsMove.SCISSORS -> RpsMove.ROCK
        }
        else -> throw Exception()
    }
}

private fun Char.toRpsMove(): RpsMove {
    return when (this.toString().lowercase()) {
        "a", "x" -> RpsMove.ROCK
        "b", "y" -> RpsMove.PAPER
        "c", "z" -> RpsMove.SCISSORS
        else -> throw Exception()
    }
}

private fun returnHumanPlayerMatchOutCome(elfPlayerMove: RpsMove, humanPlayerMove: RpsMove) : Int {
    return when(humanPlayerMove){
        RpsMove.ROCK -> 1 + when (elfPlayerMove) {
                RpsMove.ROCK -> 3
                RpsMove.PAPER -> 0
                RpsMove.SCISSORS -> 6
            }
        RpsMove.PAPER -> 2 + when (elfPlayerMove) {
            RpsMove.ROCK -> 6
            RpsMove.PAPER -> 3
            RpsMove.SCISSORS -> 0
        }
        RpsMove.SCISSORS -> 3 + when (elfPlayerMove) {
            RpsMove.ROCK -> 0
            RpsMove.PAPER -> 6
            RpsMove.SCISSORS -> 3
        }
    }
}

enum class RpsMove {
    ROCK,
    PAPER,
    SCISSORS
}
