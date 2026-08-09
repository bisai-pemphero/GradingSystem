//register student
fun registerStudent() {
    println("\n----- Register Student -----")

    print("Enter Student Id ")
    val studentId = readln().toInt()

    val existingStudent = students.find { it.id == studentId }

    if (existingStudent != null) {

        println("Student with ID $studentId already exists!")

        pause()

        return
    }

    println("Enter Student Name ")
    val studentName = readln().toString()

    print("Enter Student Course ")
    val studentCourse = readln().toString()


    val student = Student(studentId, studentName, studentCourse)

    students.add(student)
    saveStudents(students)

    println("\nStudent registered successfully!")

    pause()

}


//add marks
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

    saveStudents(students)

    println("Marks saved Successfully")

    pause()

}



fun findStudentById(): Student? {

    print("Enter Student ID: ")
    val id = readln().toInt()

    return students.find { it.id == id }

}

//View Student
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

//View All Students
fun viewAllStudents() {

    println("\n==================================================")
    println("                 ALL STUDENTS")
    println("==================================================")


    if(students.isEmpty()) {

        println("No students registered yet.")
        pause()
        return

    }


    println(
        "%-8s %-20s %-25s %-10s".format(
            "ID",
            "Name",
            "Course",
            "Grade"
        )
    )


    println("--------------------------------------------------")


    for(student in students) {

        val average = calculateAverage(student)

        val grade = calculateGrade(average)


        println(
            "%-8s %-20s %-25s %-10s".format(
                student.id,
                student.name,
                student.course,
                grade
            )
        )

    }


    println("==================================================")


    pause()

}

//delete student
fun deleteStudent() {
    println("\n---- Delete Student ---")
    print("Enter Student ID: ")


    val student = findStudentById()

    println()
    println("Student Found")
    println("ID    : ${student?.id}")
    println("Name  : ${student?.name}")

    print("\nAre you sure you want to delete this student? (Y/N): ")

    val answer = readln()

    if(answer.equals("Y", ignoreCase = true)){

        students.remove(student)

        saveStudents(students)

        println("Student deleted successfully!")

    }else{

        println("Deletion cancelled.")

    }
    pause()
}

//search student
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

//show statics
fun showStatistics() {

    println("\n----- CLASS STATISTICS -----")

    if (students.isEmpty()) {

        println("No students registered.")
        pause()
        return
    }

    val totalStudents = students.size

    val classAverage = students
        .map { calculateAverage(it) }
        .average()

    val highestStudent = students
        .maxByOrNull { calculateAverage(it) }

    val lowestStudent = students
        .minByOrNull { calculateAverage(it) }

    val passedStudents = students
        .count { calculateAverage(it) >= 50 }

    val failedStudents = students
        .count { calculateAverage(it) < 50 }

    val passRate = (passedStudents.toDouble() / totalStudents) * 100

    println()
    println("Total Students  : $totalStudents")
    println("Class Average   : %.2f".format(classAverage))

    println(
        "Highest Average : %.2f - ${highestStudent?.name}"
            .format(calculateAverage(highestStudent!!))
    )

    println(
        "Lowest Average  : %.2f - ${lowestStudent?.name}"
            .format(calculateAverage(lowestStudent!!))
    )

    println("Passed Students : $passedStudents")
    println("Failed Students : $failedStudents")
    println("Pass Rate       : %.2f%%".format(passRate))

    pause()
}