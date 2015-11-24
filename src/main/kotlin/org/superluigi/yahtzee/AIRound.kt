package org.superluigi.yahtzee

import org.superluigi.yahtzee.model.GameState
import org.superluigi.yahtzee.view.dice.RollDice
import org.superluigi.yahtzee.view.rollbutton.ScoreSelectionAction
import org.superluigi.yahtzee.view.scoresheet.EndRoundAction

object AIRound {

    fun apply() {

        RollDice.apply()

        AIDiceSelection.apply()

        if (!GameState.scoreSelection) {

            RollDice.apply()

            AIDiceSelection.apply()

            if (!GameState.scoreSelection) {

                RollDice.apply()

            }

        }

        val availableScores = ScoreSelectionAction.apply()

        val selectedField = AIScoreSelection.apply(availableScores)

        EndRoundAction.apply(selectedField)

    }

}