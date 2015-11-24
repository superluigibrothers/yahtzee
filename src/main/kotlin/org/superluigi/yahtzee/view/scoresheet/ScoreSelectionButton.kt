package org.superluigi.yahtzee.view.scoresheet

import javafx.event.ActionEvent
import javafx.event.EventHandler
import javafx.geometry.Insets
import javafx.scene.control.Button
import javafx.scene.text.Font
import org.superluigi.yahtzee.view.Elements
import org.superluigi.yahtzee.view.rollbutton.RollButtonSetup

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

        button.font = Font("Lucida Console", 25.0)

        button.onAction =

            object : EventHandler<ActionEvent> {

                override fun handle(event: ActionEvent) {

                    EndRoundAction.apply(field)

                }

            }

        Elements.scoreSheetGrid.add(button, columnIndex, rowIndex)

    }

}
