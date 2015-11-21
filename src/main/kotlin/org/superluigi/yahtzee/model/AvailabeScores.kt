package org.superluigi.yahtzee.model

import org.superluigi.yahtzee.model.LowerSection
import org.superluigi.yahtzee.model.ScoreSheet
import org.superluigi.yahtzee.model.UpperSection

object AvailabeScores {

    fun get(scoreSheet: ScoreSheet,
            upperSection: UpperSection,
            lowerSection: LowerSection): Map<String, Int> {

        val fromUpperSection =
            upperSection.fields
                .filter { field -> scoreSheet.upperSection.get(field.key) == null }
                .toList()

        val fromLowerSection =
            lowerSection.fields
                .filter { field -> scoreSheet.lowerSection.get(field.key) == null }
                .toList()

        val arrayList = arrayListOf<Pair<String, Int>>()

        arrayList.addAll(fromUpperSection)
        arrayList.addAll(fromLowerSection)

        return arrayList.toMap()

    }

}
