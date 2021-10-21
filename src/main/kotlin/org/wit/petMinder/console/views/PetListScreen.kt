package org.wit.petMinder.console.views

import org.wit.petMinder.console.controllers.PetUIController
import org.wit.petMinder.console.models.PetModel
import tornadofx.*

class PetListScreen : View("My View") {
    val petUIController: PetUIController by inject()
    val tableContent = petUIController.pets.findAll()
    val data = tableContent.observable()


    override val root = form {
        setPrefSize(600.0, 200.0)
        tableview(data) {
            readonlyColumn("ID", PetModel::id)
            readonlyColumn("Name", PetModel::name)
            readonlyColumn("Age", PetModel::age)
            readonlyColumn("Weight", PetModel::weight)
        }
        button("Close") {
            useMaxWidth = true
            action {
                runAsyncWithProgress {
                    petUIController.closeList()
                }
            }
        }
    }
}
