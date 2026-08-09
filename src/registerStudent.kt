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
    println("\nStudent registered successfully!")

    pause()

}

fun pause(){

    println("\nPress Enter to continue...")
    readln()

}