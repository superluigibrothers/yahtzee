package org.superluigi.yahtzee.view

import javafx.application.Application
import javafx.scene.Scene
import javafx.scene.layout.GridPane
import javafx.stage.Stage
import org.superluigi.yahtzee.model.Die

class View : Application() {

    override fun start(primaryStage: Stage) {

        val grid = GridPane()
        grid.gridLinesVisibleProperty().set(true)

        val dice =
            listOf(
                Die(Face.FIVE, false),
                Die(Face.FIVE, false),
                Die(Face.FIVE, false),
                Die(Face.FIVE, false),
                Die(Face.FIVE, false)
            )

        val diceButtons = DiceToButtons.apply(dice)

        SetDiceAction.apply(dice, diceButtons)

        val diceGrid = DiceGridSetup.apply(grid, diceButtons)

        val rollButton = RollButtonSetup.apply(grid)

        SetRollButtonAction.apply(rollButton, dice, diceButtons)

        val scoreSheetGrid = ScoreSheetSetup.apply(grid)

        val dialogLabel = DialogSetup.apply(grid)

        val scene = Scene(grid, 750.0, 1000.0)

        primaryStage.title = "YAHTZEE!"

        primaryStage.scene = scene

        primaryStage.show()

    }

}