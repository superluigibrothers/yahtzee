package org.superluigi.yahtzee

import org.superluigi.yahtzee.model.Die
import org.superluigi.yahtzee.view.Face

class LowerSection(private val dice: List<Die>) {

    private val faces = dice.map { it.face }

    private val values =
        faces.map { face ->
            Face.toInteger(face)
        }

    private val sumOfAllDice = Sum.calculate(values)

    private val counts =
        Face.values
            .map { face ->
                faces.filter { it == face }.size
            }

    private val threeOfAKind =
        if (counts.min()!! >= 3)
            sumOfAllDice
        else
            0

    private val fourOfAKind =
        if (counts.min()!! >= 4)
            sumOfAllDice
        else
            0

    private val fullHouse =
        if (counts.contains(3) && counts.contains(2))
            25
        else
            0

    private val smallStraight =
        if (
            faces.containsAllRaw(setOf(Face.ONE, Face.TWO, Face.THREE, Face.FOUR)) ||
            faces.containsAllRaw(setOf(Face.TWO, Face.THREE, Face.FOUR, Face.FIVE)) ||
            faces.containsAllRaw(setOf(Face.THREE, Face.FOUR, Face.FIVE, Face.SIX))
        )
            30
        else
            0

    private val largeStraight =
        if (
            faces.containsAllRaw(setOf(Face.ONE, Face.TWO, Face.THREE, Face.FOUR, Face.FIVE)) ||
            faces.containsAllRaw(setOf(Face.TWO, Face.THREE, Face.FOUR, Face.FIVE, Face.SIX))
        )
            40
        else
            0

    private val yahtzee =
        if (faces.distinct().size == 1)
            50
        else
            0

    val fields =
        hashMapOf(
            Pair("Three of a kind", threeOfAKind),
            Pair("Four of a kind", fourOfAKind),
            Pair("Full House", fullHouse),
            Pair("Small straight", smallStraight),
            Pair("Large straight", largeStraight),
            Pair("Chance", sumOfAllDice),
            Pair("Yahtzee", yahtzee)
        )

}