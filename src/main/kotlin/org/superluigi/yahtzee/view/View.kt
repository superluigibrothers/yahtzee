package org.superluigi.yahtzee.view

import javafx.application.Application
import javafx.scene.Scene
import javafx.stage.Stage

class View : Application() {

    override fun start(primaryStage: Stage) {

        val grid = Elements.grid

        val scene = Scene(grid, 750.0, 1000.0)

        primaryStage.title = "YAHTZEE!"

        primaryStage.scene = scene

        primaryStage.show()

    }

}
