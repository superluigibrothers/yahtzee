package org.superluigi.yahtzee.view.dice

enum class Face(val path: String,
                val lockedPath: String) {

    ONE("src/main/resources/one.png", "src/main/resources/one-locked.png"),
    TWO("src/main/resources/two.png", "src/main/resources/two-locked.png"),
    THREE("src/main/resources/three.png", "src/main/resources/three-locked.png"),
    FOUR("src/main/resources/four.png", "src/main/resources/four-locked.png"),
    FIVE("src/main/resources/five.png", "src/main/resources/five-locked.png"),
    SIX("src/main/resources/six.png", "src/main/resources/six-locked.png");

    companion object mapping {

        fun toInteger(face: Face) =

            when (face) {

                ONE -> 1
                TWO -> 2
                THREE -> 3
                FOUR -> 4
                FIVE -> 5
                SIX -> 6

            }

    }

}