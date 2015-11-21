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

        val scoreSheetGrid = Elements.scoreSheetGrid

        availableScoreList.forEach { pair ->



        }

    }

}