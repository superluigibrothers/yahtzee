package org.superluigi.yahtzee.view

import javafx.geometry.Pos
import javafx.scene.control.Label
import javafx.scene.layout.BorderPane
import javafx.scene.text.Font
import org.superluigi.yahtzee.model.GameState

object RefreshScoreSheet {

    fun apply() {

        Elements.scoreSheetGrid.children.clear()

        Elements.scoreSheetGrid.gridLinesVisibleProperty().set(false) // This turns out to be necessary...
        Elements.scoreSheetGrid.gridLinesVisibleProperty().set(true)

        AddScoreSheetLabels.apply()

        val userFields =
            listOf(
                GameState.userScoreSheet.upperSection.entries,
                GameState.userScoreSheet.lowerSection.entries
            ).flatten()

        userFields.forEach { entry ->

            val name = entry.key
            val score = entry.value

            val columnIndex = 1

            if (score != null) {

                val label = Label("$score")

                label.font = Font("Lucida Console", 25.0)

                val borderPane = BorderPane()

                borderPane.center = label

                val rowIndex = ScoreSheetRowIndex.apply(name)

                Elements.scoreSheetGrid.add(borderPane, columnIndex, rowIndex)

            }

        }

        val aiFields =
            listOf(
                GameState.aiScoreSheet.upperSection.entries,
                GameState.aiScoreSheet.lowerSection.entries
            ).flatten()

        aiFields.forEach { entry ->

            val name = entry.key
            val score = entry.value

            val columnIndex = 2

            if (score != null) {

                val label = Label("$score")

                label.font = Font("Lucida Console", 25.0)
                label.alignment = Pos.CENTER

                val borderPane = BorderPane()

                borderPane.center = label

                val rowIndex = ScoreSheetRowIndex.apply(name)

                Elements.scoreSheetGrid.add(borderPane, columnIndex, rowIndex)

            }

        }

        val userSum = GameState.userScoreSheet.sum
        val userBonus = GameState.userScoreSheet.bonus
        val userTotal = GameState.userScoreSheet.total

        val userSumLabel = Label("$userSum")
        val userBonusLabel = Label("$userBonus")
        val userTotalLabel = Label("$userTotal")

        if (userSum != 0) {

            userSumLabel.font = Font("Lucida Console", 25.0)
            userSumLabel.alignment = Pos.CENTER

            val borderPane = BorderPane()

            borderPane.center = userSumLabel

            Elements.scoreSheetGrid.add(borderPane, 1, 6)

        }

        if (userBonus != 0) {

            userBonusLabel.font = Font("Lucida Console", 25.0)
            userBonusLabel.alignment = Pos.CENTER

            val borderPane = BorderPane()

            borderPane.center = userBonusLabel

            Elements.scoreSheetGrid.add(borderPane, 1, 7)

        }

        if (userTotal != 0) {

            userTotalLabel.font = Font("Lucida Console", 25.0)
            userTotalLabel.alignment = Pos.CENTER

            val borderPane = BorderPane()

            borderPane.center = userTotalLabel

            Elements.scoreSheetGrid.add(borderPane, 1, 15)

        }

        val aiSum = GameState.aiScoreSheet.sum
        val aiBonus = GameState.aiScoreSheet.bonus
        val aiTotal = GameState.aiScoreSheet.total

        val aiSumLabel = Label("$userSum")
        val aiBonusLabel = Label("$userBonus")
        val aiTotalLabel = Label("$userTotal")

        if (aiSum != 0) {

            aiSumLabel.font = Font("Lucida Console", 25.0)
            aiSumLabel.alignment = Pos.CENTER

            val borderPane = BorderPane()

            borderPane.center = aiSumLabel

            Elements.scoreSheetGrid.add(borderPane, 2, 6)

        }

        if (aiBonus != 0) {

            aiBonusLabel.font = Font("Lucida Console", 25.0)
            aiBonusLabel.alignment = Pos.CENTER

            val borderPane = BorderPane()

            borderPane.center = aiBonusLabel

            Elements.scoreSheetGrid.add(borderPane, 2, 7)

        }

        if (aiTotal != 0) {

            aiTotalLabel.font = Font("Lucida Console", 25.0)
            aiTotalLabel.alignment = Pos.CENTER

            val borderPane = BorderPane()

            borderPane.center = aiTotalLabel

            Elements.scoreSheetGrid.add(borderPane, 2, 15)

        }

    }

}