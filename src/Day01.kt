fun main() {
    fun getTotalCaloriesList(input: List<String>): MutableList<Int> {
        val totalCalorieList = mutableListOf<Int>()
        val listDelimiter = ""

        val breakLines = input.mapIndexedNotNull{ index, elem -> index.takeIf{ elem == listDelimiter } }
        breakLines.forEachIndexed { index, breakLineInt ->
            val startingIndex = if(index == 0){
                0
            } else {
                breakLines[index-1]
            }
            val elfCalorieList = input.subList(startingIndex,breakLineInt).filterNot {
                it == ""
            }
            totalCalorieList.add(elfCalorieList.sumOf {
                it.toInt()
            })
        }
        return totalCalorieList
    }

    fun part1(input: List<String>): Int {
        return getTotalCaloriesList(input).max()
    }

    fun part2(input: List<String>): Int {
        val totalCaloriesList = getTotalCaloriesList(input)
        val topThreeTotalList = mutableListOf<Int>()
        repeat(3) {
            topThreeTotalList.add(totalCaloriesList.max())
            totalCaloriesList.remove(totalCaloriesList.max())
        }
        return topThreeTotalList.sum()
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day01_test")
    check(part1(testInput) == 24000)

    val input = readInput("Day01")
    println(part1(input))
    println(part2(input))
}
