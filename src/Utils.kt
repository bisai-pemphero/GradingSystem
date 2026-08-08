fun pause(){

    println("\nPress Enter to continue...")
    readln()

}

fun getValidMark(subject: String): Double {

    while (true) {

        print("Enter $subject marks: ")

        val mark = readln().toDoubleOrNull()


        if (mark != null && mark in 0.0..100.0) {

            return mark

        } else {

            println("Invalid mark! Enter a value between 0 and 100.")

        }

    }

}