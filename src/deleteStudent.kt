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

        println("Student deleted successfully!")

    }else{

        println("Deletion cancelled.")

    }
    pause()
}