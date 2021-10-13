package org.wit.petMinder.console.main

import mu.KotlinLogging
import org.wit.petMinder.console.models.PetModel
import java.awt.SystemColor.menu

val pets = ArrayList<PetModel>()
private val logger = KotlinLogging.logger {}
fun main(args: Array<String>) {
    logger.info { "Launching PetMinder Console" }
    println("PetMinder Kotlin App Version 1.0")

    var input: Int
    do {
        input = menu()
        when (input) {
            1 -> addPet()
            2 -> updatePet()
            3 -> listPets()
            4 -> searchPet()
            -1 -> println("Exiting App")
            else -> println("Invalid Option")
        }
    } while (input != -1)
    logger.info { "Shutting Down Petminder Console App" }
}

fun menu(): Int {
    var option: Int
    var input: String? = null

    println("MAIN MENU")
    println(" 1. Add Pet")
    println(" 2. Update Pet")
    println(" 3. List All Pet")
    println("-1. Exit")
    println()
    print("Enter an integer : ")
    input = readLine()!!
    option = if (input.toIntOrNull() != null && !input.isEmpty())
        input.toInt()
    else
        -9

    return option
}

fun addPet() {
    var aPet = PetModel()
    println("Add Placemark")
    println()
    println("Enter a Name: ")
    aPet.name = readLine()!!

    println("Enter date of birth")
    aPet.dob = readLine()!!
   if(aPet.name.isNotEmpty() && aPet.dob.isNotEmpty()) {
       aPet.id = pets.size.toLong()
       pets.add(aPet.copy())
       logger.info{"Placemark Added : [ $aPet ]"}
   } else {
       logger.info("Placemark Not Added")
   }
}

fun updatePet() {
    println("Update Placemark")
    println()
    listPets()
    var searckId = getId()
    val aPet = search(searckId)

    if(aPet!= null){
        print("emter a new name for ["+ aPet.name+"")
        aPet.name = readLine()!!
        println("Enter a new Description for [ "+aPet.dob+"")
        aPet.dob = readLine()!!
        println(
            "You updated [ + aPlacemark.title +  ] for title  " +
                "and [  + aPlacemark.description +  ] for description" )
    } else {
        println("Placemark Not Updated")
    }
}

fun listPets() {
    println("List All Placemarks")
    println()
    pets.forEach { logger.info("${it}") }
    println()
}

fun searchPet() {
    var searchId = getId()
    val aPet = search(searchId)
    if (aPet != null)
        println("Pet Details [ $aPet]")
    else
        println("Pet not found")

}

fun getId(): Long {
    var strID: String?
    var searchId: Long
    print("Enter id to Search/Update: ")
    strID = readLine()!!
    searchId = if (strID.toLongOrNull() != null && !strID.isEmpty())
        strID.toLong()
    else
        -9

    return searchId
}

fun search(id: Long): PetModel? {
    var foundPet: PetModel? = pets.find { p -> p.id == id }
    return foundPet
}

fun dummyDate(){
    //add later
}