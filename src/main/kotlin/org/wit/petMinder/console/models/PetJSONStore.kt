package org.wit.petMinder.console.models

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import mu.KotlinLogging
import org.wit.petMinder.console.helpers.*
import java.util.*

private val logger = KotlinLogging.logger {}

val JSON_FILE = "pets.json"
val gsonBuilder = GsonBuilder().setPrettyPrinting().create()
val listType = object : TypeToken<ArrayList<PetModel>>() {}.type

fun generateRandomId(): Long {
    return Random().nextLong()
}

class PetJSONStore : PetStore {


    var pets = mutableListOf<PetModel>()
    init {
        if (exists(JSON_FILE)) {
            deserialize()
        }
    }

    override fun findAll(): MutableList<PetModel> {
        return pets
    }

    override fun findOne(id: Long) : PetModel? {
        var foundPet: PetModel? = pets.find { p -> p.id == id }
        return foundPet
    }

    override fun create(pet: PetModel) {
        pet.id = generateRandomId()
        pets.add(pet)
        logAll()
        serialize()
    }

    override fun update(pet: PetModel) {
        var foundPet = findOne(pet.id!!)
        if (foundPet != null) {
            foundPet.name = pet.name
            foundPet.age = pet.age
            foundPet.weight = pet.weight
        }
        serialize()
    }

    override fun deleteOne(petId: Long) {
        val foundPet = findOne(petId)
        if(foundPet!= null){
            pets.remove(foundPet)
        }
        serialize()
    }


    internal fun logAll() {
        pets.forEach { logger.info("${it}") }
    }

    private fun serialize() {
        val jsonString = gsonBuilder.toJson(pets, listType)
        write(JSON_FILE, jsonString)
    }

    private fun deserialize() {
        val jsonString = read(JSON_FILE)
        pets = Gson().fromJson(jsonString, listType)
    }
}