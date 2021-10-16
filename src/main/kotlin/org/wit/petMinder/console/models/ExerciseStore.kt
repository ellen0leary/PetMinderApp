package org.wit.petMinder.console.models

interface ExerciseStore {
    fun findAll(): List<ExerciseModel>
    fun findByPet(petId: Long): List<ExerciseModel>
    fun findOne(id: Long): ExerciseModel?
    fun create(exercise: ExerciseModel)
    fun update(exercise: ExerciseModel)
    fun deleteOne(exercise: ExerciseModel)
    fun deleteByPet(petId: Long)
}