package org.wit.petMinder.console.main

import mu.KotlinLogging


private val logger = KotlinLogging.logger {}
fun main(args: Array<String>) {
 logger.info{"Launching PetMinder Console"}
 println("PetMinder Kotlin App Version 1.0")

 var input : Int
 input = menu()
}

fun menu() : Int {
 var option : Int
 var input: String ? = null

 println("MAIN MENU")
 println(" 1. Add Pet")
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
