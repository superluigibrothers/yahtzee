package org.superluigi.yahtzee.model

import org.superluigi.yahtzee.view.dice.Face

object GameState {

    val dice =
        listOf(
            Die(Face.FIVE, false),
            Die(Face.FIVE, false),
            Die(Face.FIVE, false),
            Die(Face.FIVE, false),
            Die(Face.FIVE, false)
        )

    val userScoreSheet = ScoreSheet()
    val aiScoreSheet = ScoreSheet()

    var usersTurn = true

    var diceRollsLeft = 3

    var scoreSelection = false



}

