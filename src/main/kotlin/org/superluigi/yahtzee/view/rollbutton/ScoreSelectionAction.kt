package org.superluigi.yahtzee.view.rollbutton

import javafx.event.ActionEvent
import javafx.event.EventHandler
import org.superluigi.yahtzee.model.GameState
import org.superluigi.yahtzee.model.ScoreSelection
import org.superluigi.yahtzee.view.Elements
import org.superluigi.yahtzee.view.scoresheet.DisplayScoreSelection

object ScoreSelectionAction {

    fun apply(): Map<String, Int> {

        GameState.diceRollsLeft = 3

        GameState.scoreSelection = true

        Elements.rollButton.text = "^__^"

        Elements.rollButton.onAction =

            object : EventHandler<ActionEvent> {

                override fun handle(event: ActionEvent) { }

            }

        val availableScores = ScoreSelection.apply()

        DisplayScoreSelection.apply(availableScores)

        return availableScores

    }

}
