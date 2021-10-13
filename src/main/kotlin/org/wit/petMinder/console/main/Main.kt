package org.wit.petMinder.console.main

import mu.KotlinLogging
import java.awt.SystemColor.menu


private val logger = KotlinLogging.logger {}
fun main(args: Array<String>) {
 logger.info{"Launching PetMinder Console"}
 println("PetMinder Kotlin App Version 1.0")

 var input : Int
 do {
  input = menu()
  when(input){
   1 -> println("You chose Add Pet")
   -1 -> println("Exiting App")
   else -> println("Invalud Option")
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

}

fun updatePet(){

}

fun listPets(){
 
}
