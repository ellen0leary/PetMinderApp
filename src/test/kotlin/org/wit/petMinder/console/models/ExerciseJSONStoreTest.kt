package org.wit.petMinder.console.models


import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import kotlin.random.Random

class ExerciseJSONStoreTest {
    val exerciseStore = ExerciseJSONStore()

    @Test
    fun findAllTest() {
        val test1 = ExerciseModel(0,3,"Walking", 90)
        exerciseStore.create(test1)
        assertEquals(exerciseStore.findAll().size,exerciseStore.exercises.size )
    }

    @Test
    fun findByPetTest(){
        val length = exerciseStore.exercises.size
        val test1 = ExerciseModel(0,3,"Walking", 90)
        val test2 = ExerciseModel(1,3,"Running", 30)
        exerciseStore.create(test1)
        exerciseStore.create(test2)
        val listOfExercise = exerciseStore.findByPet(3)
        assertEquals(listOfExercise.size, length +2)
    }

    @Test
    fun findOneTest(){
        val test1 = ExerciseModel(petId = 3,name = "Walking", length = 90)
        exerciseStore.create(test1)
        assertEquals(exerciseStore.exercises[exerciseStore.exercises.size-1], exerciseStore.findOne(exerciseStore.exercises[exerciseStore.exercises.size-1].id))
    }

    @Test
    fun createTest(){
        val test1 = ExerciseModel(0,3,"Walking", 90)
        exerciseStore.create(test1)
        assertTrue(exerciseStore.exercises.contains(test1))
    }

    @Test
    fun updateTest(){
        val updating = exerciseStore.exercises[0]
        val newLength = Random.nextInt()
        updating.length = newLength
        exerciseStore.update(updating)
        assertEquals(updating.length, newLength)
    }


    @Test
    fun deleteOneTest(){
        val deleting = exerciseStore.exercises[0]
        exerciseStore.deleteOne(deleting.id)
        assertFalse(exerciseStore.exercises.contains(deleting))
    }

}