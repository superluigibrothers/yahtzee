package org.superluigi.yahtzee.view.rollbutton

import javafx.event.ActionEvent
import javafx.event.EventHandler
import org.superluigi.yahtzee.model.Roll
import org.superluigi.yahtzee.model.GameState
import org.superluigi.yahtzee.view.Elements
import org.superluigi.yahtzee.view.dice.SetBackground

object SetRollButtonAction {

    fun roll() {

        Elements.rollButton.text = "ROLL!"

        Elements.rollButton.onAction =

            object : EventHandler<ActionEvent> {

                override fun handle(event: ActionEvent) {

                    val diceToRoll = GameState.dice.filter { !it.locked }

                    diceToRoll.forEach { die ->

                        die.face = Roll.apply()

                    }

                    GameState.dice.forEachIndexed { index, die ->

                        val dieButton = Elements.diceButtons[index]

                        SetBackground.apply(die, dieButton)

                    }

                    GameState.diceRollsLeft--

                    if (GameState.diceRollsLeft == 0) {

                        ScoreSelectionAction.apply()

                    }

                }

            }

    }

    fun selectScore() {

        Elements.rollButton.onAction =

            object : EventHandler<ActionEvent> {

                override fun handle(event: ActionEvent) {

                    ScoreSelectionAction.apply()

                }

            }

    }

}