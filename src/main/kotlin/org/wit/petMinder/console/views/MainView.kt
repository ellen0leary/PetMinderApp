package org.wit.petMinder.console.views

class MainView {
    val TEXT_RESET = "\u001B[0m"
    val PURPLE = "\u001b[1;35m"
    val CYAN = "\u001b[0;36m"
    val BLUE = "\u001b[0;34m"
    val GREEN = "\u001b[0;32m"
    val YELLOW = "\u001b[0;33m"

//    val CYAN ="\033[1;36m"
    fun menu() : Int {
        var option : Int
        var input: String?

        println(PURPLE+ "MAIN MENU"+ TEXT_RESET)
        println(CYAN +" 1. Add Pet" )
        println(" 2. Update Pet")
        println(" 3. List All Pets")
        println(" 4. Search Pet")
        println(" 5. Delete Pet"+ TEXT_RESET)
        println(PURPLE+ "-------------------" + TEXT_RESET)
        println(BLUE +" 6. Add Feed")
        println(" 7. Update Feed")
        println(" 8. List All Feed")
        println(" 9. Search Feed")
        println("10. Delete Feed" + TEXT_RESET)
        println(PURPLE+ "-------------------" + TEXT_RESET)
        println(GREEN + "11. Add Exercise")
        println("12. Update Exercise")
        println("13. List All Exercise")
        println("14. Search Exercise")
        println("15. Delete Exercise"+ TEXT_RESET)
        println(PURPLE+ "-------------------" + TEXT_RESET)
        println(YELLOW + "16. See All Pets Data")
        println("17. See Pets Exercise")
        println("18. See Pets Feeds"+ TEXT_RESET)
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