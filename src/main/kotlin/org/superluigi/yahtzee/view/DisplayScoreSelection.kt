package org.superluigi.yahtzee.view

import org.superluigi.yahtzee.model.GameState

object DisplayScoreSelection {

    fun apply(availableScores: Map<String, Int>) {

        val availableScoreList = availableScores.toList()

        val columnIndex =
            if (GameState.usersTurn)
                1
            else
                2

        availableScoreList.forEach { field ->

            val label = field.first

            when (label) {

                "Ones" -> ScoreSelectionButton.apply(field, columnIndex, 0)
                "Twos" -> ScoreSelectionButton.apply(field, columnIndex, 1)
                "Threes" -> ScoreSelectionButton.apply(field, columnIndex, 2)
                "Fours" -> ScoreSelectionButton.apply(field, columnIndex, 3)
                "Fives" -> ScoreSelectionButton.apply(field, columnIndex, 4)
                "Sixes" -> ScoreSelectionButton.apply(field, columnIndex, 5)
                "Three of a kind" -> ScoreSelectionButton.apply(field, columnIndex, 8)
                "Four of a kind" -> ScoreSelectionButton.apply(field, columnIndex, 9)
                "Full House" -> ScoreSelectionButton.apply(field, columnIndex, 10)
                "Small straight" -> ScoreSelectionButton.apply(field, columnIndex, 11)
                "Large straight" -> ScoreSelectionButton.apply(field, columnIndex, 12)
                "Chance" -> ScoreSelectionButton.apply(field, columnIndex, 13)
                "Yahtzee" -> ScoreSelectionButton.apply(field, columnIndex, 14)

            }

        }

    }

}