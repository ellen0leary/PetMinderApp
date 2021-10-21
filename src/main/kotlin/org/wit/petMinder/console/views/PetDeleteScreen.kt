package org.wit.petMinder.console.views

import javafx.beans.property.SimpleIntegerProperty
import javafx.beans.property.SimpleLongProperty
import javafx.geometry.Orientation
import org.wit.petMinder.console.controllers.PetUIController
import org.wit.petMinder.console.models.PetModel
import tornadofx.*
import tornadofx.Stylesheet.Companion.fieldset
import tornadofx.Stylesheet.Companion.form

class PetDeleteScreen : View("Pet Delete") {
    val model = ViewModel()
    val petUIController: PetUIController by inject()
    val tableContent = petUIController.pets.findAll()
    val data = tableContent.observable()

    val _id = model.bind { SimpleLongProperty() }

    override val root = form {
        setPrefSize(600.0, 250.0)
        tableview(data) {
            readonlyColumn("ID", PetModel::id)
            readonlyColumn("Name", PetModel::name)
            readonlyColumn("Age", PetModel::age)
            readonlyColumn("Weight", PetModel::weight)
        }
        fieldset(labelPosition = Orientation.VERTICAL) {
            field("Id to Delete") {
                textfield(_id).required()
            }
            button("Delete") {
                enableWhen(model.valid)
                useMaxWidth = true
                action {
                    runAsyncWithProgress {
                        petUIController.delete(_id.value.toLong())
                    }
                }
            }
            button("Close") {
                useMaxWidth = true
                action {
                    runAsyncWithProgress {
                        petUIController.closeDelete()
                    }
                }
            }
        }

    }

    override fun onDock() {
        _id.value = 0
    }
}
