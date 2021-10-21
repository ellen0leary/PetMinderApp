package org.wit.petMinder.console.controllers

import org.wit.petMinder.console.views.MenuScreen
import org.wit.petMinder.console.views.PetMenuScreen
import tornadofx.*

class MenuUIController:Controller() {
//    val placemark

    fun openPets() {
        runLater {
            find(MenuScreen::class).replaceWith(PetMenuScreen::class,  sizeToScene = true, centerOnScreen = true)
        }
    }
}
