package org.wit.petMinder.console.controllers

import mu.KotlinLogging
import org.wit.petMinder.console.views.MainView

class MainController {
    val logger = KotlinLogging.logger {}
    val petController = PetController()
    val mainView = MainView()

    init {
        logger.info { "Launching Pet Console App" }
        println("Pet Kotlin App Version 4.0")
    }

    fun start() {
        var input: Int

        do {
            input = menu()
            when (input) {
                1 -> petController.add()
                2 -> petController.update()
                3 -> petController.list()
                4 -> petController.search()
                5 -> petController.delete()
                -99 -> petController.dummyData()
                -1 -> println("Exiting App")
                else -> println("Invalid Option")
            }
            println()
        } while (input != -1)
        logger.info { "Shutting Down Placemark Console App" }
    }

    fun menu() :Int { return mainView.menu() }
}