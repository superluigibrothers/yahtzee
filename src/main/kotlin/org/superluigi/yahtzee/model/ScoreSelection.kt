package org.superluigi.yahtzee.model

import org.superluigi.yahtzee.model.UpperSection

object ScoreSelection {

    fun apply(): Map<String, Int> {

        val upperSection = UpperSection(GameState.dice)
        val lowerSection = LowerSection(GameState.dice)

        val scoreSheet =
            if (GameState.usersTurn)
                GameState.userScoreSheet
            else
                GameState.aiScoreSheet

        val availableScores = AvailabeScores.get(scoreSheet, upperSection, lowerSection)

        return availableScores

    }

}