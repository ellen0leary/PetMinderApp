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
        return exercises
    }

    override fun findByPet(petId: Long): List<ExerciseModel> {
        val list =  ArrayList<ExerciseModel>()
        for(i in exercises){
            if(i.petId == petId){
                list.add(i)
            }
        }
        return list
    }

    override fun findOne(id: Long): ExerciseModel? {
        var foundExercise : ExerciseModel? = exercises.find{p -> p.id == id}
        return foundExercise
    }

    override fun create(exercise: ExerciseModel) {
        exercise.id = getExerciseId()
        exercises.add(exercise)
        logAll()
    }

    override fun update(exercise: ExerciseModel) {
        var foundExercise = findOne(exercise.id!!)
        if(foundExercise != null) {
            foundExercise.name = exercise.name
            foundExercise.length = exercise.length
        }
    }

    override fun deleteByPet(petId: Long) {
        for(i in exercises){
            if(i.petId == petId){
                var foundExercise = findOne(i.id!!)
                if(foundExercise!= null){
                    exercises.remove(foundExercise)
                }
            }
        }
    }

    override fun deleteOne(exerciseId: Long) {
        val foundExercise = findOne(exerciseId)
        if(foundExercise!= null){
            exercises.remove(foundExercise)
        }
    }

    internal fun logAll(){
        exercises.forEach{ logger.info("${it}")}
    }
}