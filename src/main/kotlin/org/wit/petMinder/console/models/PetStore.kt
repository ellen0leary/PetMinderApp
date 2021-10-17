package org.wit.petMinder.console.models

interface PetStore {
    fun findAll(): List<PetModel>
    fun findOne(id: Long) : PetModel?
    fun create(pet: PetModel)
    fun update(pet: PetModel)
    fun deleteOne(petId: Long)
}