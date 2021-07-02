val listOfids = arrayListOf<Int>()
val listOfSchools = arrayListOf<School>()

fun main(args: Array<String>) {
   // println("Hello World!")
    firstPage()
}

fun firstPage() {

    println("Enter Your Username")
    val usernameInput = readLine();
    println("Enter Your Password")
    val passwordInput = readLine();

    if (usernameInput == "admin" && passwordInput == "admin")
        admin()
    //else


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

                }
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
    for (item in listOfSchools){

        print(item.id )

        for (i in 0 until 16 - item.id.toString().length){
            print(" ")
        }
        print("|")

        print(item.name )

        for (i in 0 until 14 - item.name.length){
            print(" ")
        }
        println("|")
        println("-------------------------------")




    }

}