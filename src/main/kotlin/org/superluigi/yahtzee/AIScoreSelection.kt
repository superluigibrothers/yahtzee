package org.superluigi.yahtzee

object AIScoreSelection {

    // First pass :)

    fun apply(availableScores: Map<String, Int>): Pair<String, Int> {

        val availableScoreList = availableScores.toList()

        val selectedScore =
            availableScoreList
                .reduce { field1, field2 -> if (field1.second > field2.second) field1 else field2 }

        return selectedScore

    }

}
