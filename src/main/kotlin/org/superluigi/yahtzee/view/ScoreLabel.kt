package org.superluigi.yahtzee.view

import javafx.geometry.Pos
import javafx.scene.control.Label
import javafx.scene.text.Font

object ScoreLabel {

    fun apply(score: Int,
              columnIndex: Int,
              rowIndex: Int) {

        val scoreLabel = Label("$score")

        scoreLabel.font = Font("Lucida Console", 20.0)

        scoreLabel.alignment = Pos.CENTER

        Elements.scoreSheetGrid.add(scoreLabel, columnIndex, rowIndex)

    }

}