package org.superluigi.yahtzee.view

import javafx.scene.control.Button
import javafx.scene.control.Label
import javafx.scene.layout.GridPane
import org.superluigi.yahtzee.model.GameState

object Elements {

    val grid = GridPane()
    val diceButtons: List<Button>
    val rollButton: Button
    val scoreSheetGrid: GridPane
    val dialogLabel: Label

    init {

        grid.gridLinesVisibleProperty().set(true)

        val dice = GameState.dice

        diceButtons = DiceToButtons.apply(dice)

        SetDiceAction.apply()

        DiceGridSetup.apply(grid, diceButtons)

        rollButton = RollButtonSetup.apply(grid)

        SetRollButtonAction.roll()

        scoreSheetGrid = ScoreSheetSetup.apply(grid)

        AddScoreSheetLabels.apply()

        dialogLabel = DialogSetup.apply(grid)

    }

}
