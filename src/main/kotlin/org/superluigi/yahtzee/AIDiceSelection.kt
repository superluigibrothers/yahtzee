package org.superluigi.yahtzee

import org.superluigi.yahtzee.model.GameState
import org.superluigi.yahtzee.view.Elements
import org.superluigi.yahtzee.view.dice.ToggleLockAction
import org.superluigi.yahtzee.view.rollbutton.ScoreSelectionAction
import java.util.*

object AIDiceSelection {

    // For now, the AI selects the dice to keep at random.

    fun apply() {

        val dice = GameState.dice
        val buttons = Elements.diceButtons

        val random = Math.random()

        if (random < 0.1) {

            ScoreSelectionAction.apply()

            return

        }

        val numKeptDice = Math.floor(Math.random() * 5.0).toInt()

        val allIndices = arrayListOf(0, 1, 2, 3, 4)

        Collections.shuffle(allIndices)

        val selectedIndices = allIndices.take(numKeptDice)

        dice.forEachIndexed { index, die ->

            if (selectedIndices.contains(index)) {

                val button = buttons[index]

                ToggleLockAction.apply(die, button)

            }

        }

    }

}