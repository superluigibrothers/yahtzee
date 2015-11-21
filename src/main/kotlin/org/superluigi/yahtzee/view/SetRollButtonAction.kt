package org.superluigi.yahtzee.view

import javafx.event.ActionEvent
import javafx.event.EventHandler
import org.superluigi.yahtzee.Roll
import org.superluigi.yahtzee.ScoreSelection
import org.superluigi.yahtzee.model.GameState

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

                        GameState.diceRollsLeft = 3

                        GameState.scoreSelection = true

                        Elements.rollButton.text = "^__^"

                        Elements.rollButton.onAction =

                            object : EventHandler<ActionEvent> {

                                override fun handle(event: ActionEvent) {
                                }

                            }

                        ScoreSelection.apply()

                    }

                }

            }

    }

    fun selectScore() {

        Elements.rollButton.onAction =

            object : EventHandler<ActionEvent> {

                override fun handle(event: ActionEvent) {

                    GameState.diceRollsLeft = 3

                    GameState.scoreSelection = true

                    Elements.rollButton.text = "^__^"

                    Elements.rollButton.onAction =

                        object : EventHandler<ActionEvent> {

                            override fun handle(event: ActionEvent) {
                            }

                        }

                    ScoreSelection.apply()

                }

            }

    }

}
