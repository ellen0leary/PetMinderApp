package org.wit.petMinder.console.views

class MainView {

    fun menu() : Int {
        var option : Int
        var input: String?

        println("MAIN MENU")
        println(" 1. Add Pet")
        println(" 2. Update Pet")
        println(" 3. List All Pets")
        println(" 4. Search Pet")
        println(" 5. Delete Pet")
        println("-------------------")
        println(" 6. Add Feed")
        println(" 7. List All Feed")
        println(" 8. Search Feed")
        println(" 9. Delete Feed")
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
}