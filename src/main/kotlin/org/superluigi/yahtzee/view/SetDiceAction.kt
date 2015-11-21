package org.superluigi.yahtzee.view

import javafx.event.ActionEvent
import javafx.event.EventHandler
import javafx.scene.control.Button
import org.superluigi.yahtzee.model.Die

object SetDiceAction {

    fun apply(dice: List<Die>,
              diceButtons: List<Button>) {

        dice.forEachIndexed { index, die ->

            val button = diceButtons[index]

            button.onAction =
                object : EventHandler<ActionEvent> {

                    override fun handle(event: ActionEvent) {

                        if (die.locked) {

                            die.locked = false

                        }
                        else {

                            die.locked = true

                        }

                        SetBackground.apply(die, button)

                    }

                }

        }

    }

}