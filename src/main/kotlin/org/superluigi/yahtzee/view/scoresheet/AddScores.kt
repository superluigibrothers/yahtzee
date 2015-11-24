package org.superluigi.yahtzee.view.scoresheet

import org.superluigi.yahtzee.model.ScoreSheet

object AddScores {

    fun apply(scoreSheet: ScoreSheet,
              columnIndex: Int) {

        val fields =
            listOf(
                scoreSheet.upperSection.entries,
                scoreSheet.lowerSection.entries
            ).flatten()

        fields.forEach { entry ->

            val name = entry.key
            val score = entry.value

            if (score != null) {

                val rowIndex = ScoreSheetRowIndex.apply(name)

                AddScore.apply(score, columnIndex, rowIndex)

            }

        }

        val sum = scoreSheet.sum
        val bonus = scoreSheet.bonus
        val total = scoreSheet.total

        if (sum != 0) {

            AddScore.apply(sum, columnIndex, 6)

        }

        if (bonus != 0) {

            AddScore.apply(bonus, columnIndex, 7)

        }

        if (total != 0) {

            AddScore.apply(total, columnIndex, 15)

        }

    }

}