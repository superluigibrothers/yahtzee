package org.superluigi.yahtzee.view.dice

import org.superluigi.yahtzee.model.GameState
import org.superluigi.yahtzee.model.Roll
import org.superluigi.yahtzee.view.Elements

object RollDice {

    fun apply() {

        val diceToRoll = GameState.dice.filter { !it.locked }

        diceToRoll.forEach { die ->

            die.face = Roll.apply()

        }

        GameState.dice.forEachIndexed { index, die ->

            val dieButton = Elements.diceButtons[index]

            SetBackground.apply(die, dieButton)

        }

    }

}