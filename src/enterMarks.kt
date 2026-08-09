fun enterMarks() {
    println("\n----- Enter Student Marks -----")

    print("Enter Student Id: ")

    val student = findStudentById()

    if (student == null) {

        println("Student not found!")

        pause()

        return
    }


    student.maths = getValidMark("Maths")

    student.english = getValidMark("English")

    student.programming = getValidMark("Programming")

    student.database = getValidMark("Database")

    println("Marks saved Successfully")

    pause()

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

fun findStudentById(): Student? {

    print("Enter Student ID: ")
    val id = readln().toInt()

    return students.find { it.id == id }

}