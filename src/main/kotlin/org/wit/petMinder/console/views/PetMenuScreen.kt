package org.wit.petMinder.console.views

import javafx.application.Platform
import javafx.geometry.Orientation
import org.wit.petMinder.console.controllers.PetUIController
import tornadofx.*

class PetMenuScreen : View("Pet Menu") {
    val petUIController = PetUIController()
    override val root = form {
        setPrefSize(400.0, 200.0)
        fieldset(labelPosition = Orientation.VERTICAL) {
            text("")
            button("Add Pet") {

                isDefaultButton = true
                useMaxWidth = true
                action {
                    runAsyncWithProgress {
                        petUIController.openAdd()
                    }
                }
            }
            text("")
            button("List Pet") {

                isDefaultButton = true
                useMaxWidth = true
                action {
                    runAsyncWithProgress {
                        petUIController.openList()
                    }
                }
            }
            text("")
            button("Delete Pet") {

                isDefaultButton = true
                useMaxWidth = true
                action {
                    runAsyncWithProgress {
                        petUIController.openDelete()
                    }
                }
            }
            text("")
            button("Back") {

                isDefaultButton = true
                useMaxWidth = true
                action {
                    runAsyncWithProgress {
                        petUIController.closeMenu()
                    }
                }
            }

        }

    }
}
