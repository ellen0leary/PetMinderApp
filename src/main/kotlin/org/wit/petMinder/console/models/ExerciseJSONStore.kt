package org.wit.petMinder.console.models


import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import mu.KotlinLogging
import org.wit.placemark.console.helpers.exists
import org.wit.placemark.console.helpers.read
import org.wit.placemark.console.helpers.write
import java.util.ArrayList

private val logger = KotlinLogging.logger {}

val JSON_FILE_EXE = "exercises.json"
val gsonBuilder_exe = GsonBuilder().setPrettyPrinting().create()
val listType_exe = object : TypeToken<ArrayList<ExerciseModel>>() {}.type

class ExerciseJSONStore: ExerciseStore {
    var exercises = mutableListOf<ExerciseModel>()
    init {
        if (exists(JSON_FILE_EXE)) {
            deserialize()
        }
    }

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
        exercise.id = generateRandomId()
        exercises.add(exercise)
        logAll()
        serialize()
    }

    override fun update(exercise: ExerciseModel) {
        var foundExercise = findOne(exercise.id!!)
        if(foundExercise != null) {
            foundExercise.name = exercise.name
            foundExercise.length = exercise.length
        }
        serialize()
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
        serialize()
    }

    override fun deleteOne(exerciseId: Long) {
        val foundExercise = findOne(exerciseId)
        if(foundExercise!= null){
            exercises.remove(foundExercise)
        }
        serialize()
    }


    internal fun logAll() {
        exercises.forEach { logger.info("${it}") }
    }

    private fun serialize() {
        val jsonString = gsonBuilder_exe.toJson(exercises, listType_exe)
        write(JSON_FILE_EXE, jsonString)
    }

    private fun deserialize() {
        val jsonString = read(JSON_FILE_EXE)
        exercises = Gson().fromJson(jsonString, listType_exe)
    }
}