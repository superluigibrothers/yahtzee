package org.superluigi.yahtzee

import org.superluigi.yahtzee.model.Die
import org.superluigi.yahtzee.view.Face

class UpperSection(private val dice: List<Die>) {

    private val ones = dice.filter { it.face == Face.ONE }.size * 1
    private val twos = dice.filter { it.face == Face.TWO }.size * 2
    private val threes = dice.filter { it.face == Face.THREE }.size * 3
    private val fours = dice.filter { it.face == Face.FOUR }.size * 4
    private val fives = dice.filter { it.face == Face.FIVE }.size * 5
    private val sixes = dice.filter { it.face == Face.SIX }.size * 6

    val fields =
        hashMapOf(
            Pair("Ones", ones),
            Pair("Twos", twos),
            Pair("Threes", threes),
            Pair("Fours", fours),
            Pair("Fives", fives),
            Pair("Sixes", sixes)
        )

}