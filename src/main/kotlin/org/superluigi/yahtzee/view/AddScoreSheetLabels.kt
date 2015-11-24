package org.superluigi.yahtzee.view

import javafx.geometry.Insets
import javafx.scene.text.Font

object AddScoreSheetLabels {

    fun apply() {

        val scoreSheetLabels = ScoreSheetLabels.labels

        val insets = Insets(0.0, 0.0, 0.0, 20.0)
        val font = Font("Lucida Console", 20.0)

        scoreSheetLabels.forEachIndexed { index, label ->

            label.padding = insets
            label.font = font

            Elements.scoreSheetGrid.add(label, 0, index)

        }

    }

}