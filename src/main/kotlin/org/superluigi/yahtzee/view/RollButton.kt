package org.superluigi.yahtzee.view

import javafx.scene.control.Button
import javafx.scene.layout.BorderPane
import javafx.scene.layout.GridPane
import javafx.scene.layout.RowConstraints

object RollButton {

    val rollPane = BorderPane()
    val rollPaneRow = RowConstraints()
    val rollButton = Button("ROLL!")

    fun addToGrid(grid: GridPane) {

        rollPaneRow.percentHeight = 5.0

        grid.rowConstraints.add(rollPaneRow)

        rollPane.center = rollButton

        grid.add(rollPane, 0, 1)

    }
}

