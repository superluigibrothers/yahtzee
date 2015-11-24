package org.superluigi.yahtzee.model

object ResetScoreSheet {

    fun apply(scoreSheet: ScoreSheet) {

        scoreSheet.upperSection.keys

            .forEach { key ->

                scoreSheet.upperSection.put(key, null)

            }

        scoreSheet.lowerSection.keys

            .forEach { key ->

                scoreSheet.lowerSection.put(key, null)

            }

        scoreSheet.sum = 0
        scoreSheet.bonus = 0
        scoreSheet.total = 0

    }

}