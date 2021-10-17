package org.wit.petMinder.console.views

import org.wit.petMinder.console.models.PetJSONStore
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
        println(" 5. Delete Pet")
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

    fun listPets(pets : PetJSONStore) {
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
        pet.age = -1
        println()
        print("Enter a Name : ")
        pet.name = readLine()!!
        print("Enter a Age : ")
        pet.age = readLine()!!.toInt()
        print("Enter a weight: ")
        pet.weight = readLine()!!.toFloat()


        return pet.name.isNotEmpty() && (pet.age > -1)
    }

    fun updatePetData(pet : PetModel) : Boolean {
        var tempName: String?
        var tempAge: Int?
        var tempWeight: Float?

        if (pet != null) {
            print("Enter a new Title for [ " + pet.name + " ] : ")
            tempName = readLine()!!
            print("Enter a new Description for [ " + pet.age + " ] : ")
            tempAge = readLine()!!.toIntOrNull()
            print("Enter a new Weight for [ "+pet.weight+ "] :")
            tempWeight = readLine()!!.toFloat()

            if (!tempName.isNullOrEmpty() && tempAge != null) {
                pet.name = tempName
                pet.age = tempAge
                pet.weight = tempWeight
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