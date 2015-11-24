package org.superluigi.yahtzee

import org.superluigi.yahtzee.model.GameState
import org.superluigi.yahtzee.view.DisplayScoreSelection

object ScoreSelection {

    fun apply() {

        val upperSection = UpperSection(GameState.dice)
        val lowerSection = LowerSection(GameState.dice)

        val scoreSheet =
            if (GameState.usersTurn)
                GameState.userScoreSheet
            else
                GameState.aiScoreSheet

        val availableScores = AvailabeScores.get(scoreSheet, upperSection, lowerSection)

        DisplayScoreSelection.apply(availableScores)

        // Refresh the score sheet somehow.

    }
}

