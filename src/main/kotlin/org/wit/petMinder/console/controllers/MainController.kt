package org.wit.petMinder.console.controllers

import mu.KotlinLogging
import org.wit.petMinder.console.views.MainView

class MainController {
    val logger = KotlinLogging.logger {}
    val petController = PetController()
    val feedController = FeedController()
    val exerciseController = ExerciseController()
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
                6 -> feedController.add()
                7 -> feedController.update()
                8-> feedController.list()
                9 -> feedController.search()
                10 -> feedController.delete()
                11-> exerciseController.add()
                12 -> exerciseController.update()
                13 -> exerciseController.list()
                14 -> exerciseController.search()
                15 -> exerciseController.delete()
                16 -> allPetData()
                17 -> petsExercise()
                18 -> petsFeeding()
                -99 -> allDummyData()
                -1 -> println("Exiting App")
                else -> println("Invalid Option")
            }
            println()
        } while (input != -1)
        logger.info { "Shutting Down Placemark Console App" }
    }

    fun menu() :Int { return mainView.menu() }

    fun allDummyData(){
        petController.dummyData()
        feedController.dummyData()
        exerciseController.dummyData()
    }

    fun allPetData() {
        val id: Long = petController.getPetId()
        if(!id.equals(-1)){
            petController.listByPet(id)
            exerciseController.listByPet(id)
            feedController.listByPet(id)
        }
    }

    fun petsExercise(){
        val id: Long = petController.getPetId()
        if(!id.equals(-1)){
            exerciseController.listByPet(id)
        }
    }

    fun petsFeeding(){
        val id: Long = petController.getPetId()
        if(!id.equals(-1)){
            feedController.listByPet(id)
        }
    }
}