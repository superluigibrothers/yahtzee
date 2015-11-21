package org.superluigi.yahtzee.view

import javafx.scene.control.Button
import javafx.scene.image.Image
import javafx.scene.layout.*
import org.superluigi.yahtzee.model.Die
import java.io.ByteArrayInputStream
import java.io.File

object SetBackground {

    fun apply(die: Die, button: Button) {

        val face = die.face

        val imagePath =
            if (die.locked)
                face.lockedPath
            else
                face.path

        val imageBytes = File(imagePath).readBytes()

        val inputStream = ByteArrayInputStream(imageBytes)

        val image = Image(inputStream)

        val backgroundImage =
            BackgroundImage(
                image,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                BackgroundSize(100.0, 100.0, true, true, true, true)
            )

        val background = Background(backgroundImage)

        button.background = background

    }

}