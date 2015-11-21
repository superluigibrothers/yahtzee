package org.superluigi.yahtzee.view

enum class Face(val path: String,
                val lockedPath: String) {

    ONE("src/main/resources/one.png", "src/main/resources/one-locked.png"),
    TWO("src/main/resources/two.png", "src/main/resources/two-locked.png"),
    THREE("src/main/resources/three.png", "src/main/resources/three-locked.png"),
    FOUR("src/main/resources/four.png", "src/main/resources/four-locked.png"),
    FIVE("src/main/resources/five.png", "src/main/resources/five-locked.png"),
    SIX("src/main/resources/six.png", "src/main/resources/six-locked.png");

    companion object mapping {
        fun fromInt(int: Int) =

            when (int) {

                1 -> ONE
                2 -> TWO
                3 -> THREE
                4 -> FOUR
                5 -> FIVE
                6 -> SIX
                else -> throw IllegalArgumentException("Die value must be between 1 and 6.")
            }

    }

}