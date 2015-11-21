package org.superluigi.yahtzee.view

import javafx.scene.layout.ColumnConstraints
import javafx.scene.layout.GridPane
import javafx.scene.layout.RowConstraints

object ScoreSheet {

    val scoreSheetGrid = GridPane()
    val labelColumn = ColumnConstraints()
    val scoreColumn = ColumnConstraints()
    val scoreSheetGridRow = RowConstraints()
    val scoreSheetRow = RowConstraints()

    fun addToGrid(grid: GridPane) {

        scoreSheetGrid.gridLinesVisibleProperty().set(true)

        labelColumn.percentWidth = 80.0

        scoreColumn.percentWidth = 10.0

        scoreSheetRow.percentHeight = 6.25

        for (i in 1..16) {

            scoreSheetGrid.rowConstraints.add(scoreSheetRow)

        }

        scoreSheetGrid.columnConstraints.add(labelColumn)

        scoreSheetGrid.columnConstraints.add(scoreColumn)
        scoreSheetGrid.columnConstraints.add(scoreColumn)

        scoreSheetGridRow.percentHeight = 75.0

        val userScoreSheetLabels = ScoreSheetLabels().labels

        userScoreSheetLabels.forEachIndexed { index, label ->

            scoreSheetGrid.add(label, 0, index)

        }

        grid.rowConstraints.add(scoreSheetGridRow)

        grid.add(scoreSheetGrid, 0, 2)

    }
}

