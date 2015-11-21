package org.superluigi.yahtzee.model

import org.superluigi.yahtzee.view.dice.Face

data class Die(
    var face: Face,
    var locked: Boolean
)
