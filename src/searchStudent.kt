fun searchStudent(){
    println("\n---- Search Student ---")
    print("Enter Student ID: ")
    val id = readln().toInt()


    val student = students.find { it.id == id }

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
    println("        STUDENT DETAILS")
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