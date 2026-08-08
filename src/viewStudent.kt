fun viewStudent() {

    println("\n----- View Student Results -----")

    val student = findStudentById()

    if(student == null){

        println("Student not found!")
        pause()
        return
    }

    val total = calculateTotal(student)

    val average = calculateAverage(student)

    val grade = calculateGrade(average)


    println()
    println("---------------------------------")
    println("        STUDENT REPORT CARD")
    println("---------------------------------")


    println("ID: ${student.id}")
    println("Name: ${student.name}")
    println("Course: ${student.course}")

    println()

    println("Maths       : ${student.maths}")
    println("English     : ${student.english}")
    println("Programming : ${student.programming}")
    println("Database    : ${student.database}")

    println()

    println("Total       : $total")
    println("Average     : $average")
    println("Grade       : $grade")


    if(average >= 50){

        println("Status      : PASS")

    } else {

        println("Status      : FAIL")

    }

    println("---------------------------------")

    pause()

}

fun calculateTotal(student: Student): Double {
    return student.maths +
            student.english +
            student.programming +
            student.database
}

fun calculateAverage(student: Student): Double {
    val total = calculateTotal(student)
    return total/4
}

fun calculateGrade(average: Double): String {


    return when {

        average >= 80 -> "A"

        average >= 70 -> "B"

        average >= 60 -> "C"

        average >= 50 -> "D"

        else -> "F"

    }
}




