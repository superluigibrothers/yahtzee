package org.superluigi.yahtzee.view.dice

import javafx.event.ActionEvent
import javafx.event.EventHandler
import org.superluigi.yahtzee.model.GameState
import org.superluigi.yahtzee.view.Elements
import org.superluigi.yahtzee.view.rollbutton.SetRollButtonAction

object SetDiceAction {

    fun apply() {

        GameState.dice.forEachIndexed { index, die ->

            val button = Elements.diceButtons[index]

            button.onAction =
                object : EventHandler<ActionEvent> {

                    override fun handle(event: ActionEvent) {

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

        }

    }

}