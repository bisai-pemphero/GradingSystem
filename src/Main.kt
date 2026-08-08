//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
val students = mutableListOf<Student>()

fun main() {
    menu()
}

fun menu(){
    while (true) {
        println()
        println("=================================")
        println("     STUDENT GRADE SYSTEM")
        println("=================================")
        println("1. Register Student")
        println("2. Enter Marks")
        println("3. View Student")
        println("4. View All Students")
        println("5. Search Student")
        println("6. Delete Students")
        println("7. Exit")

        val choice = readln().toIntOrNull() ?: 0

        when (choice) {
            1 -> registerStudent()
            2 -> enterMarks()
            3 -> viewStudent()
            4 -> viewAllStudents()
            5 -> searchStudent()
            6 -> deleteStudent()
            7 -> {
                println("Calculator Closed Successfully")
                break
            }

            else -> println("Invalid input")
        }
    }
}

