package org.superluigi.yahtzee.view.dice

import javafx.scene.control.Button
import org.superluigi.yahtzee.model.Die
import org.superluigi.yahtzee.model.GameState
import org.superluigi.yahtzee.view.Elements
import org.superluigi.yahtzee.view.rollbutton.SetRollButtonAction

object ToggleLockAction {

    fun apply(die: Die,
              button: Button) {

        if (GameState.diceRollsLeft < 3) {

            if (die.locked) {

                die.locked = false

                Elements.rollButton.text= "ROLL!"

                SetRollButtonAction.roll()

            } else {

                die.locked = true

                if (GameState.dice.all { it.locked }) {

                    Elements.rollButton.text = "Click to pick your score."

                    SetRollButtonAction.selectScore()

                }

            }

            SetBackground.apply(die, button)

        }

    }

}