package org.wit.petMinder.console.views


import org.wit.petMinder.console.views.PetView
import org.wit.petMinder.console.main.pets
import org.wit.petMinder.console.models.PetMemStore
import org.wit.petMinder.console.models.PetModel

class PetView {

    fun menu() : Int {

        var option : Int
        var input: String?

        println("MAIN MENU")
        println(" 1. Add Pet")
        println(" 2. Update Pet")
        println(" 3. List All Pets")
        println(" 4. Search Pet")
        println("-1. Exit")
        println()
        print("Enter Option : ")
        input = readLine()!!
        option = if (input.toIntOrNull() != null && !input.isEmpty())
            input.toInt()
        else
            -9
        return option
    }

    fun listPets(pets : PetMemStore) {
        println("List All Pets")
        println()
        pets.logAll()
        println()
    }

    fun showPet(pets : PetModel) {
        if(pets != null)
            println("Pet Details [ $pets ]")
        else
            println("Pet Not Found...")
    }

    fun addPetData(pet : PetModel) : Boolean {

        println()
        print("Enter a Name : ")
        pet.name = readLine()!!
        print("Enter a Date of Birth : ")
        pet.dob = readLine()!!

        return pet.name.isNotEmpty() && pet.dob.isNotEmpty()
    }

    fun updatePetData(pet : PetModel) : Boolean {

        var tempName: String?
        var tempDOB: String?

        if (pet != null) {
            print("Enter a new Title for [ " + pet.name + " ] : ")
            tempName = readLine()!!
            print("Enter a new Description for [ " + pet.dob + " ] : ")
            tempDOB = readLine()!!

            if (!tempName.isNullOrEmpty() && !tempDOB.isNullOrEmpty()) {
                pet.name = tempName
                pet.dob = tempDOB
                return true
            }
        }
        return false
    }

    fun getId() : Long {
        var strId : String? // String to hold user input
        var searchId : Long // Long to hold converted id
        print("Enter id to Search/Update : ")
        strId = readLine()!!
        searchId = if (strId.toLongOrNull() != null && !strId.isEmpty())
            strId.toLong()
        else
            -9
        return searchId
    }
}