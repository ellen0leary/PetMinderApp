package org.wit.petMinder.console.views

import javafx.beans.property.SimpleIntegerProperty
import javafx.beans.property.SimpleStringProperty
import javafx.geometry.Orientation
import org.wit.petMinder.console.controllers.PetUIController
import tornadofx.*

class PetAddScreen : View("My View") {
    val model = ViewModel()
    val pet: PetUIController by inject()
    val _name = model.bind { SimpleStringProperty() }
    val _age = model.bind { SimpleIntegerProperty() }
    val _weight = model.bind { SimpleStringProperty() }

    override val root = form {
        setPrefSize(600.0, 200.0)
        fieldset(labelPosition = Orientation.VERTICAL) {
            text("")
            field("Name") {
                textfield(_name).required()
            }
            field("Age") {
                textfield(_age).required()
            }
            field("Weight") {
                textfield(_weight).required()
            }
            button("Add") {
                enableWhen(model.valid)
                useMaxWidth = true
                action {
                    runAsyncWithProgress {
                       pet.add(_name.value.toString(),_age.value.toString(), _weight.value.toString())

                    }
                }
            }
            button("Close") {
                useMaxWidth = true
                action {
                    runAsyncWithProgress {
                        pet.closeAdd()
                    }
                }
            }
        }
    }
}
