package org.superluigi.yahtzee.view

import javafx.event.ActionEvent
import javafx.event.EventHandler
import org.superluigi.yahtzee.model.GameState

object SetDiceAction {

    fun apply() {

        GameState.dice.forEachIndexed { index, die ->

            val button = Elements.diceButtons[index]

            button.onAction =
                object : EventHandler<ActionEvent> {

                    override fun handle(event: ActionEvent) {

                        if (die.locked) {

                            die.locked = false

                        }
                        else {

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