package org.wit.petMinder.console.models


import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import kotlin.random.Random

class PetJSONStoreTest {
    val petStore = PetJSONStore()

    @Test
    fun findAllTest() {
        val test1 = PetModel(0,"Spot",5, 90f)
        petStore.create(test1)
        assertEquals(petStore.findAll().size, petStore.pets.size)
    }


    @Test
    fun findOneTest(){
        val test1 = PetModel(name = "Sooty", age = 90, weight = 4f)
        petStore.create(test1)
        assertEquals(
            petStore.pets[petStore.pets.size - 1],
            petStore.findOne(petStore.pets[petStore.pets.size - 1].id)
        )
    }

    @Test
    fun createTest(){
        val test1 = PetModel(0,"Shadow", 7,90f)
        petStore.create(test1)
        assertTrue(petStore.pets.contains(test1))
    }

    @Test
    fun updateTest(){
        val updating = petStore.pets[0]
        val newWeigth = Random.nextFloat()
        updating.weight = newWeigth
        petStore.update(updating)
        assertEquals(updating.weight, newWeigth)
    }

    @Test
    fun deleteOneTest(){
        val deleting = petStore.pets[0]
        petStore.deleteOne(deleting.id)
        assertFalse(petStore.pets.contains(deleting))
    }
}