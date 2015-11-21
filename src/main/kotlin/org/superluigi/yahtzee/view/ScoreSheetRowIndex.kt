package org.superluigi.yahtzee.view

object ScoreSheetRowIndex {

    fun apply(fieldName: String) =

        when (fieldName) {

            "Ones"              -> 0
            "Twos"              -> 1
            "Threes"            -> 2
            "Fours"             -> 3
            "Fives"             -> 4
            "Sixes"             -> 5
            "Three of a kind"   -> 8
            "Four of a kind"    -> 9
            "Full House"        -> 10
            "Small straight"    -> 11
            "Large straight"    -> 12
            "Chance"            -> 13
            "Yahtzee"           -> 14
            else -> throw IllegalArgumentException("Invalid field name.")

        }

}