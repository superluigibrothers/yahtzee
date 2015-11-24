package org.superluigi.yahtzee.model

import org.superluigi.yahtzee.model.Sum
import org.superluigi.yahtzee.view.dice.Face

class LowerSection(private val dice: List<Die>) {

    private val faces = dice.map { it.face }

    private val values =
        faces.map { face ->
            Face.toInteger(face)
        }

    private val sumOfAllDice = Sum.calculate(values)

    private val counts =
        Face.values
            .map { value ->
                faces.filter { it == value }.size
            }

    private val threeOfAKind =
        if (counts.max()!! >= 3)
            sumOfAllDice
        else
            0

    private val fourOfAKind =
        if (counts.max()!! >= 4)
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