package org.wit.petMinder.console.models

import mu.KotlinLogging

private val logger = KotlinLogging.logger {}
var lastId = 0L

internal fun getId(): Long {
    return lastId++
}

class PetMemStore : PetStore {

    val pets = ArrayList<PetModel>()

    override fun findAll(): List<PetModel> {
        return pets
    }

    override fun findOne(id: Long) : PetModel? {
        var foundPet: PetModel? = pets.find { p -> p.id == id }
        return foundPet
    }

    override fun create(pet: PetModel) {
        pet.id = getId()
        pets.add(pet)
        logAll()
    }

    override fun update(pet: PetModel) {
        var foundPet = findOne(pet.id!!)
        if (foundPet != null) {
            foundPet.name = pet.name
            foundPet.age = pet.age
            foundPet.weight = pet.weight
        }
    }

    internal fun logAll() {
        pets.forEach { logger.info("${it}") }
    }

    override fun deleteOne(petId: Long) {
        val foundPet = findOne(petId)
        if(foundPet!= null){
            pets.remove(foundPet)
        }
    }
}