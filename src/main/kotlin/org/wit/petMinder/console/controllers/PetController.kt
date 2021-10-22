package org.wit.petMinder.console.controllers

import mu.KotlinLogging
import org.wit.petMinder.console.models.PetJSONStore
import org.wit.petMinder.console.models.PetModel
import org.wit.petMinder.console.views.PetView

class PetController {

//    val pets = PetMemStore()
    val pets = PetJSONStore()
    val petView = PetView()
    val logger = KotlinLogging.logger {}

    fun add(){
        var aPet = PetModel()

        if (petView.addPetData(aPet))
            pets.create(aPet)
        else
            logger.info{"Pet Not Added"}
    }

    fun listByPet(id: Long){
        val foundPet = pets.findOne(id)
        petView.listOne(foundPet)
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

    fun getPetId() : Long{
        val aPet = search(petView.getId())!!
        if(aPet!=null)
            return aPet.id
        return -1
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
            println("Pet Deleted...")
            petView.listPets(pets)
        }
        else
            println("Pet Not Deleted...")
    }

    fun dummyData() {
        pets.create(PetModel(id= 1, name = "Fluffy", age = 10, weight=3.5f))
        pets.create(PetModel(id=2, name= "Apollo", age = 4, weight = 2.5f))
        pets.create(PetModel(id=3, name = "Milo", age = 3, weight=4f))
    }
}