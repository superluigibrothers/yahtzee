package org.superluigi.yahtzee.view.scoresheet

import javafx.scene.control.Label
import javafx.scene.layout.BorderPane
import javafx.scene.text.Font
import org.superluigi.yahtzee.view.Elements

object AddScore {

    fun apply(score: Int,
              columnIndex: Int,
              rowIndex: Int) {

        val label = Label("$score")

        label.font = Font("Lucida Console", 25.0)

        val borderPane = BorderPane()

        borderPane.center = label

        Elements.scoreSheetGrid.add(borderPane, columnIndex, rowIndex)

    }

}