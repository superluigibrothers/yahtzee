package org.superluigi.yahtzee.view.rollbutton

import javafx.event.ActionEvent
import javafx.event.EventHandler
import org.superluigi.yahtzee.model.GameState
import org.superluigi.yahtzee.model.ResetScoreSheet
import org.superluigi.yahtzee.view.Elements
import org.superluigi.yahtzee.view.dice.RollDice
import org.superluigi.yahtzee.view.scoresheet.RefreshScoreSheet

object SetRollButtonAction {

    fun roll() {

        Elements.rollButton.text = "ROLL!"

        Elements.rollButton.onAction =

            object : EventHandler<ActionEvent> {

                override fun handle(event: ActionEvent) {

                    RollDice.apply()

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

    fun newGame() {

        Elements.rollButton.onAction =

            object : EventHandler<ActionEvent> {

                override fun handle(event: ActionEvent) {

                    ResetScoreSheet.apply(GameState.userScoreSheet)
                    ResetScoreSheet.apply(GameState.aiScoreSheet)

                    RefreshScoreSheet.apply()

                    Elements.rollButton.text = "ROLL!"
                    Elements.dialogLabel.text = "YAHTZEE"

                    SetRollButtonAction.roll()

                }

            }

    }

}
