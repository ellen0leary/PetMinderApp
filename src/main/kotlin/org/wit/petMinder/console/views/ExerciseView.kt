package org.wit.petMinder.console.views

import org.wit.petMinder.console.models.ExerciseJSONStore
import org.wit.petMinder.console.models.ExerciseModel

class ExerciseView {

    fun listExercise(exercises: ExerciseJSONStore){
        println("List All Exercises")
        println()
        exercises.logAll()
        println()

    }

    fun showExercise(exercise : ExerciseModel){
        if(exercise != null){
            println("Exercise Details [ $exercise ]")
        } else {
            println("Exercise not found")
        }
    }

    fun addExerciseData(exercise: ExerciseModel): Boolean {
        exercise.petId = -1
        exercise.length = -1

        print("Enter a new pet")
        exercise.petId = readLine()!!.toLong()
        print("Enter a new name: ")
        exercise.name = readLine()!!
        print("Enter a new length")
        exercise.length = readLine()!!.toInt()

        return exercise.name.isNotEmpty() && (exercise.length > -1) && exercise.petId >-1
    }

    fun  updateExerciseData(exercise: ExerciseModel): Boolean {
        var tempId : Long?
        var tempName: String?
        var tempLength: Int?

        if(exercise!= null){
            print("Enter a new pet")
            tempId = readLine()!!.toLong()
            print("Enter a new name: ")
            tempName = readLine()!!
            print("Enter a new length")
            tempLength = readLine()!!.toInt()

            if (!tempName.isNullOrEmpty() && tempLength != null && tempId !=null) {
                exercise.name = tempName
                exercise.petId = tempId
                exercise.length = tempLength
                return true
            }
        }
        return false
    }

    fun getId(): Long {
        var strId: String?
        var searchId: Long

        print("Enter id to Search/Update : ")
        strId = readLine()!!
        searchId = if(strId.toLongOrNull() != null && strId.isNotEmpty())
            strId.toLong()
        else
            -9
        return searchId
    }
}