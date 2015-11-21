package org.superluigi.yahtzee.view

import javafx.scene.layout.GridPane
import org.superluigi.yahtzee.model.Die
import org.superluigi.yahtzee.view.*

object Elements {

    val grid = GridPane()

    val dice =
        listOf(
            Die(Face.FIVE, false),
            Die(Face.FIVE, false),
            Die(Face.FIVE, false),
            Die(Face.FIVE, false),
            Die(Face.FIVE, false)
        )

    val diceButtons = DiceToButtons.apply(dice)

    val diceGrid = DiceGridSetup.apply(grid, diceButtons)

    val rollButton = RollButtonSetup.apply(grid)

    val scoreSheetGrid = ScoreSheetSetup.apply(grid)

    val dialogLabel = DialogSetup.apply(grid)

}