package org.superluigi.yahtzee.view

import javafx.event.ActionEvent
import javafx.event.EventHandler
import javafx.geometry.Insets
import javafx.scene.control.Button
import javafx.scene.text.Font
import org.superluigi.yahtzee.AddSelectedScore
import org.superluigi.yahtzee.model.GameState

object ScoreSelectionButton {

    fun apply(field: Pair<String, Int>,
              columnIndex: Int,
              rowIndex: Int) {

        val score = field.second

        val button = Button("$score")

        button.padding = Insets(0.0, 0.0, 0.0, 0.0)

        button.prefWidth = RollButtonSetup.rollPane.width
        button.prefHeight = RollButtonSetup.rollPane.height
        button.maxWidth = Double.MAX_VALUE
        button.maxHeight = Double.MAX_VALUE

        button.font = Font("Lucida Console", 30.0)

        button.onAction =

            object : EventHandler<ActionEvent> {

                override fun handle(event: ActionEvent) {

                    val scoreSheet =
                        if (GameState.usersTurn)
                            GameState.userScoreSheet
                        else
                            GameState.aiScoreSheet

                    AddSelectedScore.apply(scoreSheet, field)

                    GameState.scoreSelection = false

                    GameState.usersTurn = !GameState.usersTurn

                    RefreshScoreSheet.apply()

                }

            }

        Elements.scoreSheetGrid.add(button, columnIndex, rowIndex)

    }

}
