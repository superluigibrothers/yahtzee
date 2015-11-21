package org.superluigi.yahtzee

class DiceRoll(
    private val diceSelection: (List<Int>) -> Pair<List<Int>, Boolean>
) {

    fun apply(dice: List<Int>): Pair<List<Int>, Boolean> {

        val selection =

            if (dice.isEmpty()) {

                Pair(listOf(), false)

            }
            else {

                diceSelection(dice)

            }

        val keptDice = selection.first
        val keptAll = selection.second

        if (keptAll) {

            return Pair(dice, true)

        }

        val numDiceToRoll = 5 - keptDice.size

<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> 37573f5f6fbb8464b35457a98e5a292bec1163ec
        val newDice = arrayListOf<Int>()

        newDice.addAll(keptDice)
        // This is broken
        for (i in 1..numDiceToRoll) {

            newDice.add(1)

        }
<<<<<<< HEAD
=======
=======
        val diceRoll = RollDice.apply(numDiceToRoll)

        val newDice = arrayListOf<Int>()

        newDice.addAll(keptDice)
        newDice.addAll(diceRoll)
>>>>>>> 76193c43060df173cd1282cd794e74e3dffac0de
>>>>>>> 37573f5f6fbb8464b35457a98e5a292bec1163ec

        newDice.forEach {

            print("$it ")

        }

        return Pair(newDice, false)

    }

}