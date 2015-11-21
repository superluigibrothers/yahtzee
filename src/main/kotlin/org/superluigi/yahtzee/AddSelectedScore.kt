package org.superluigi.yahtzee

object AddSelectedScore {

    fun apply(scoreSheet: ScoreSheet, selectedField: Pair<String, Int>): ScoreSheet {

        if (scoreSheet.upperSection.containsKey(selectedField.first)) {

            scoreSheet.upperSection.put(selectedField.first, selectedField.second)

        }
        else {

            scoreSheet.lowerSection.put(selectedField.first, selectedField.second)

        }

        val nonNullFromUpperSection =
            scoreSheet.upperSection
                .values
                .filterNotNull()

        val sum = Sum.calculate(nonNullFromUpperSection)

        val bonus =
            if (sum > 63)
                35
            else
                0

        val nonNullFromLowerSection =
            scoreSheet.lowerSection
                .values
                .filterNotNull()

        val lowerSectionSum = Sum.calculate(nonNullFromLowerSection)

        val total = sum + bonus + lowerSectionSum

        scoreSheet.sum = sum
        scoreSheet.bonus = bonus
        scoreSheet.total = total

        return scoreSheet

    }

}