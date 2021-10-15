package org.wit.petMinder.console.controllers

import mu.KotlinLogging
import org.wit.petMinder.console.main.petView
import org.wit.petMinder.console.main.pets
import org.wit.petMinder.console.models.PetMemStore
import org.wit.petMinder.console.models.PetModel
import org.wit.petMinder.console.views.PetView

class PetController {

    val pets = PetMemStore()
    val petView = PetView()
    val logger = KotlinLogging.logger {}

    init {
        logger.info { "Launching Pet Console App" }
        println("Pet Kotlin App Version 4.0")
    }

    fun start() {
        var input: Int

        do {
            input = menu()
            when (input) {
                1 -> add()
                2 -> update()
                3 -> list()
                4 -> search()
                -99 -> dummyData()
                -1 -> println("Exiting App")
                else -> println("Invalid Option")
            }
            println()
        } while (input != -1)
        logger.info { "Shutting Down Placemark Console App" }
    }

    fun menu() :Int { return petView.menu() }

    fun add(){
        var aPet = PetModel()

        if (petView.addPetData(aPet))
            pets.create(aPet)
        else
            logger.info{"Pet Not Added"}
    }

    fun list() {
        petView.listPets(pets)
    }

    fun update() {
        petView.listPets(pets)
        var searchId = petView.getId()
        val aPet = search(searchId)

        if(aPet != null) {
            if(petView.updatePetData(aPet)) {
                pets.update(aPet)
                petView.showPet(aPet)
                logger.info{"Pet Updated : [ $aPet ]"}
            }
            else
                logger.info{"Pet Not Updated"}
        }
        else
            println("Pet Not Updated...")
    }

    fun search() {
        val aPet = search(petView.getId())!!
        petView.showPet(aPet)
    }


    fun search(id: Long) : PetModel? {
        var foundPet = pets.findOne(id)
        return foundPet
    }

    fun dummyData() {
        pets.create(PetModel(name = "Fluffy", dob = "Yesterday"))
        pets.create(PetModel(name= "Apollo", dob = "2 weeks ago"))
        pets.create(PetModel(name = "Milo", dob = "2 months ags"))
    }
}