package org.wit.petMinder.console.models

import mu.KotlinLogging

private val logger = KotlinLogging.logger{}
var exerId = 0L

internal fun getExerciseId(): Long{
    return exerId++
}

class ExerciseMemStore: ExerciseStore {

    var exercises = ArrayList<ExerciseModel>()

    override fun findAll(): List<ExerciseModel> {
        TODO("Not yet implemented")
    }

    override fun findByPet(petId: Long): List<ExerciseModel> {
        TODO("Not yet implemented")
    }

    override fun findOne(id: Long): ExerciseModel? {
        TODO("Not yet implemented")
    }

    override fun create(exercise: ExerciseModel) {
        TODO("Not yet implemented")
    }

    override fun update(exercise: ExerciseModel) {
        TODO("Not yet implemented")
    }

    override fun deleteByPet(petId: Long) {
        TODO("Not yet implemented")
    }

    override fun deleteOne(exercise: ExerciseModel) {
        TODO("Not yet implemented")
    }

    internal fun logAll(){
        exercises.forEach{ logger.info("${it}")}
    }
}