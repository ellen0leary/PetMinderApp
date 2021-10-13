package org.wit.petMinder.console.main

import mu.KotlinLogging
import org.wit.petMinder.console.models.PetModel
import java.awt.SystemColor.menu

var pet = PetModel()
private val logger = KotlinLogging.logger {}
fun main(args: Array<String>) {
 logger.info{"Launching PetMinder Console"}
 println("PetMinder Kotlin App Version 1.0")

 var input : Int
 do {
  input = menu()
  when(input){
   1 -> addPet()
   2-> updatePet()
   -1 -> listPets()
   else -> println("Invalid Option")
  }
 } while (input!= -1)
 logger.info{"Shutting Down Petminder Console App"}
}

fun menu() : Int {
 var option : Int
 var input: String ? = null

 println("MAIN MENU")
 println(" 1. Add Pet")
 println(" 2. Update Pet")
 println(" 3. List All Pet")
 println("-1. Exit")
 println()
 print("Enter an integer : ")
 input = readLine()!!
 option = if(input.toIntOrNull() != null && !input.isEmpty())
      input.toInt()
 else
      -9

 return option
}

fun addPet(){
 println("Add Placemark")
 println()
 println("Enter a Name: ")
 pet.name = readLine()!!

 println("Enter date of birth")
 pet.dob = readLine()!!
 println("You enterec ["+ pet.name +"]for name and ["+pet.dob+"] for date of birth")

}

fun updatePet(){
 println("Update Placemark")
 println()
 println("Enter a new Name for "+ pet.name+": ")
 pet.name = readLine()!!

 println("Enter a new date of birth for "+pet.name+": " )
 pet.dob = readLine()!!
 println("You enterec ["+ pet.name +"]for name and ["+pet.dob+"] for date of birth")
}

fun listPets(){
 println("you choose list all pets")
}
