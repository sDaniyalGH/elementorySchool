val listOfids = arrayListOf<Int>()
val listOfSchools = arrayListOf<School>()
val listOfUsernames = arrayListOf<String>()
val listOfModirs = arrayListOf<Modir>()
lateinit var currentModir : Modir

fun main(args: Array<String>) {
    // println("Hello World!")
    firstPage()
}

fun firstPage() {

    while (true) {
        println("Enter Your Username")
        val usernameInput = readLine();
        println("Enter Your Password")
        val passwordInput = readLine();

        if (usernameInput == "admin" && passwordInput == "admin")
            admin()

        for (item in listOfModirs)
            if (usernameInput == item.usernameM && passwordInput == item.passwordM) {
                currentModir = item
                modir();
            }
    }
}

fun admin() {

    while (true) {
        println("Welcome Admin\n\n")
        println("1-Create New School")
        println("2-Create New Modir")
        println("3-Log Out")

        val input = readLine();

        when (input) {
            "1" -> {

                println("Enter The Name Of School")
                val nameSchoolInput = readLine()!!;

                val id = createId();
                val school = School(id, nameSchoolInput)
                listOfSchools.add(school)
                listOfids.add(id)
                println("Created !!!")
            }
            "2" -> {

                if (listOfSchools.size == 0) {
                    println("There is No School")
                } else {

                    printSchools()
                    println("\n Select The ID")

                    val inputt = readLine();

                    // TODO: ۰۳/۰۷/۲۰۲۱ if mistake
                    for (item in listOfSchools)
                        if (item.id == inputt!!.toInt()) {

                            println("Enter Your Name ")
                            val name = readLine()!!;
                            println("Enter Your Username ")
                            val username = readLine()!!;
                            println("Enter Your Password ")
                            val password = readLine()!!;
                            val id = createId();

                            val modir = Modir(name, username, password, id, item)
                            listOfUsernames.add(username)
                            listOfids.add(id)
                            listOfModirs.add(modir)

                        }
                }
            }
            "3" -> {
                break
            }

        }
    }
}

fun createId(): Int {

    if (listOfids.size == 0)
        return 1;
    else {
        listOfids.sort()
        return (listOfids.get(listOfids.size - 1) + 1)
    }


}

fun printSchools() {

    println("-------------------------------")
    println("       ID       |      Name    ")
    println("-------------------------------")
    for (item in listOfSchools) {

        print(item.id)

        for (i in 0 until 16 - item.id.toString().length) {
            print(" ")
        }
        print("|")

        print(item.name)

        for (i in 0 until 14 - item.name.length) {
            print(" ")
        }
        println("|")
        println("-------------------------------")


    }

}

fun modir() {

    println("\n\n Welcome Modir !!!!")
    println("Name : ${currentModir.nameM}")

    println("1-Lesson")
    println("2-Klass")
    println("3-Student")
    println("4-Teacher")
    println("5-Teacher")
    println("6-See The Lessons Of Klass")
    println("7-See The Students Of Klass")
    println("8-See The Marks Of Students")
    println("9-See The Average Of Klass")

}