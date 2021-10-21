package org.wit.petMinder.console.controllers

import javafx.beans.property.SimpleIntegerProperty
import mu.KotlinLogging
import org.wit.petMinder.console.models.PetJSONStore
import org.wit.petMinder.console.models.PetModel
import org.wit.petMinder.console.views.*
import tornadofx.*


class PetUIController : Controller() {

    val pets = PetJSONStore()
    val logger = KotlinLogging.logger {}

    fun add(name:String, age: String, weight: String) {
        val newPet = PetModel(name= name, age=age.toInt(), weight = weight.toFloat())
        pets.create(newPet)
    }

    fun delete(id: Long){
        println(id)
        pets.deleteOne(id)
    }

    fun openAdd() {
        runLater {
            find(PetMenuScreen::class).replaceWith(PetAddScreen::class,  sizeToScene = true, centerOnScreen = true)
        }
    }

    fun openList(){
        runLater {
            find(PetMenuScreen::class).replaceWith(PetListScreen::class,  sizeToScene = true, centerOnScreen = true)
        }
    }

    fun openDelete(){
        runLater {
            find(PetMenuScreen::class).replaceWith(PetDeleteScreen::class,  sizeToScene = true, centerOnScreen = true)
        }
    }

    fun closeList(){
        runLater {
            find(PetListScreen::class).replaceWith(PetMenuScreen::class,  sizeToScene = true, centerOnScreen = true)
        }
    }

    fun closeAdd() {
        runLater {
            find(PetAddScreen::class).replaceWith(PetMenuScreen::class,  sizeToScene = true, centerOnScreen = true)
        }
    }

    fun closeDelete(){
        runLater {
            find(PetDeleteScreen::class).replaceWith(PetMenuScreen::class,  sizeToScene = true, centerOnScreen = true)
        }
    }
}