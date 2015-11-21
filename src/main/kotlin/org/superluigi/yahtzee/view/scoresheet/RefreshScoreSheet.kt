package org.superluigi.yahtzee.view.scoresheet

import org.superluigi.yahtzee.model.GameState
import org.superluigi.yahtzee.view.Elements
import org.superluigi.yahtzee.view.scoresheet.AddScoreSheetLabels
import org.superluigi.yahtzee.view.scoresheet.AddScores

object RefreshScoreSheet {

    fun apply() {

        Elements.scoreSheetGrid.children.clear()

        Elements.scoreSheetGrid.gridLinesVisibleProperty().set(false) // This turns out to be necessary...
        Elements.scoreSheetGrid.gridLinesVisibleProperty().set(true)

        AddScoreSheetLabels.apply()

        AddScores.apply(GameState.userScoreSheet, 1)
        AddScores.apply(GameState.aiScoreSheet, 2)

    }

}