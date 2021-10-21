package org.wit.petMinder.console.views

import javafx.application.Platform
import javafx.geometry.Orientation
import org.wit.petMinder.console.controllers.MenuUIController
import tornadofx.*

class MenuScreen: View("Pet Minder Main Menu") {
    val menuUIController: MenuUIController by inject()

    override val root = form {
        setPrefSize(400.0, 200.0)
        fieldset(labelPosition = Orientation.VERTICAL) {
            text("")
            button("Pets") {

                isDefaultButton = true
                useMaxWidth = true
                action {
                    runAsyncWithProgress {
                        menuUIController.openPets()
                    }
                }
            }
                text("")
            button("Exercise") {

                isDefaultButton = true
                useMaxWidth = true
                action {
                    runAsyncWithProgress {
//                        placemarkUIController.loadListScreen()
                    }
                }
            }
            text("")
            button("Food") {

                isDefaultButton = true
                useMaxWidth = true
                action {
                    runAsyncWithProgress {
//                        placemarkUIController.loadListScreen()
                    }
                }
            }
            text("")
            button("Exit") {

                isDefaultButton = true
                useMaxWidth = true
                action {
                    runAsyncWithProgress {
                        Platform.exit();
                        System.exit(0);
                    }
                }
            }
        }

    }
}