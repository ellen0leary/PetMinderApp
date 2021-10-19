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
        println(" 7. Update Feed")
        println(" 8. List All Feed")
        println(" 9. Search Feed")
        println("10. Delete Feed")
        println("-------------------")
        println("11. Add Exercise")
        println("12. Update Exercise")
        println("13. List All Exercise")
        println("14. Search Exercise")
        println("15. Delete Exercise")
        println("-------------------")
        println("16. See All Pets Data")
        println("17. See Pets Exercise")
        println("18. See Pets Feeds")
        println("99. Add Dummy Data")
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