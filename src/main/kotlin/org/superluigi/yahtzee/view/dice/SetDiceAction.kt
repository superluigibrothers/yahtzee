package org.superluigi.yahtzee.view.dice

import javafx.event.ActionEvent
import javafx.event.EventHandler
import org.superluigi.yahtzee.model.GameState
import org.superluigi.yahtzee.view.Elements

object SetDiceAction {

    fun apply() {

        GameState.dice.forEachIndexed { index, die ->

            val button = Elements.diceButtons[index]

            button.onAction =

                object : EventHandler<ActionEvent> {

                    override fun handle(event: ActionEvent) {

                        if (GameState.usersTurn) {

                            ToggleLockAction.apply(die, button)

                        }

                    }

                }

        }

    }

}