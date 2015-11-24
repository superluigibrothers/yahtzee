package org.superluigi.yahtzee.view.scoresheet

import org.superluigi.yahtzee.AIRound
import org.superluigi.yahtzee.model.AddSelectedScore
import org.superluigi.yahtzee.model.GameState
import org.superluigi.yahtzee.model.ScoreSheetComplete
import org.superluigi.yahtzee.view.Elements
import org.superluigi.yahtzee.view.rollbutton.SetRollButtonAction

object EndRoundAction {

    fun apply(selectedField: Pair<String, Int>) {

        val scoreSheet =
            if (GameState.usersTurn)
                GameState.userScoreSheet
            else
                GameState.aiScoreSheet

        AddSelectedScore.apply(scoreSheet, selectedField)

        RefreshScoreSheet.apply()

        GameState.scoreSelection = false

        GameState.usersTurn = !GameState.usersTurn

        GameState.dice.forEach { die ->

            die.locked = false

        }

        if (!(ScoreSheetComplete.apply(GameState.userScoreSheet) && ScoreSheetComplete.apply(GameState.aiScoreSheet))) {

            if (!GameState.usersTurn) {

                AIRound.apply()

            } else {

                SetRollButtonAction.roll()

            }

        }
        else {

            if (GameState.userScoreSheet.total > GameState.aiScoreSheet.total) {

                Elements.dialogLabel.text = "You win! :D"

            }
            else if (GameState.userScoreSheet.total < GameState.aiScoreSheet.total) {

                Elements.dialogLabel.text = "Oh noez you lose :("

            }
            else {

                Elements.dialogLabel.text = "It's a tie!"

            }

            Elements.rollButton.text = "Click to play again!"

            SetRollButtonAction.newGame()

        }

    }

}