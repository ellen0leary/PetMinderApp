package org.wit.petMinder.console.main

import jdk.nashorn.internal.runtime.JSType.toLong
import mu.KotlinLogging
import org.wit.petMinder.console.controllers.PetController
import org.wit.petMinder.console.models.PetMemStore
import org.wit.petMinder.console.models.PetModel
import org.wit.petMinder.console.views.PetView
import java.awt.SystemColor.menu

val pets = PetMemStore()
val petView = PetView()
private val logger = KotlinLogging.logger {}
fun main(args: Array<String>) {
    PetController().start()
}