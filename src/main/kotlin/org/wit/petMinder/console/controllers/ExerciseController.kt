package org.wit.petMinder.console.controllers

import mu.KotlinLogging
import org.wit.petMinder.console.models.ExerciseJSONStore
import org.wit.petMinder.console.models.ExerciseModel
import org.wit.petMinder.console.views.ExerciseView

class ExerciseController {
    val exercises = ExerciseJSONStore()
    val exerciseView = ExerciseView()
    val logger = KotlinLogging.logger{}


    fun add(){
        var aExercise = ExerciseModel()

        if(exerciseView.addExerciseData(aExercise))
            exercises.create(aExercise)
        else
            logger.info{"Exercise not added"}
    }

    fun list(){
        exerciseView.listExercise(exercises)
    }

    fun update(){
        exerciseView.listExercise(exercises)
        var searchId = exerciseView.getId()
        val aExercise = search(searchId)

        if(aExercise!=null){
            if(exerciseView.updateExerciseData(aExercise)){
                exercises.update(aExercise)
                exerciseView.showExercise(aExercise)
                logger.info{"Exercise updated : [ $aExercise ] "}
            } else {
                logger.info {"Exercise not updated"}
            }
        }else {
            println("Exercise Not updated")
        }
    }

    fun search(){
        val aExercise = search(exerciseView.getId())!!
        exerciseView.showExercise(aExercise)
    }

    fun search(id: Long): ExerciseModel?{
        val foundExercise = exercises.findOne(id)
        return foundExercise
    }

    fun delete(){
        exerciseView.listExercise(exercises)
        var searchId = exerciseView.getId()
        val aExercise = search(searchId)

        if(aExercise!=null) {
            exercises.deleteOne(aExercise.id)
            println("Exercise Deleted... ")
            exerciseView.listExercise(exercises)
        }else {
            println("Exercise Not Deleted.....")
        }
    }

    fun dummyData(){
        //add later
    }
}
