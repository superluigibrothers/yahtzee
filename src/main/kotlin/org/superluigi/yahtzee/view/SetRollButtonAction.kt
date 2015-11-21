package org.superluigi.yahtzee.view

import javafx.event.ActionEvent
import javafx.event.EventHandler
import javafx.scene.control.Button
import org.superluigi.yahtzee.Roll
import org.superluigi.yahtzee.model.Die

object SetRollButtonAction {

    fun apply(rollButton: Button,
              dice: List<Die>,
              diceButtons: List<Button>) {

        rollButton.text = "ROLL!"

        rollButton.onAction =

            object: EventHandler<ActionEvent> {

                override fun handle(event: ActionEvent) {

                    val diceToRoll = dice.filter { !it.locked }

                    diceToRoll.forEach { die ->

                        die.face = Roll.apply()

                    }

                    dice.forEachIndexed { index, die ->

                        val dieButton = diceButtons[index]

                        SetBackground.apply(die, dieButton)

                    }

                }

            }

    }

}

