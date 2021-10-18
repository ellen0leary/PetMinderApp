package org.wit.petMinder.console.controllers

import mu.KotlinLogging
import org.wit.petMinder.console.models.PetJSONStore
import org.wit.petMinder.console.models.PetMemStore
import org.wit.petMinder.console.models.PetModel
import org.wit.petMinder.console.views.PetView
import org.wit.placemark.console.helpers.logger

class PetController {

//    val pets = PetMemStore()
    val pets = PetJSONStore()
    val petView = PetView()


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

    fun delete() {
        petView.listPets(pets)
        var searchId = petView.getId()
        val aPet = search(searchId)

        if(aPet != null) {
            pets.deleteOne(aPet.id)
            println("Placemark Deleted...")
            petView.listPets(pets)
        }
        else
            println("Placemark Not Deleted...")
    }

    fun dummyData() {
        pets.create(PetModel(name = "Fluffy", age = 10, weight=3.5f))
        pets.create(PetModel(name= "Apollo", age = 4, weight = 2.5f))
        pets.create(PetModel(name = "Milo", age = 3, weight=4f))
    }
}