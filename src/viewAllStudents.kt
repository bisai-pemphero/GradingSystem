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