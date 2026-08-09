import java.io.File

 val FILE_NAME = "student.csv"

//save students
fun saveStudents(students: List<Student>) {

    val file = File(FILE_NAME)

    file.printWriter().use { writer ->

        writer.println(
            "id,name,course,maths,english,programming,database"
        )

        for (student in students) {

            writer.println(
                "${student.id}," +
                        "${student.name}," +
                        "${student.course}," +
                        "${student.maths}," +
                        "${student.english}," +
                        "${student.programming}," +
                        "${student.database}"
            )
        }
    }
}

//load students
fun loadStudents(): MutableList<Student> {

    val students = mutableListOf<Student>()

    val file = File(FILE_NAME)

    if (!file.exists()) {
        return students
    }

    val lines = file.readLines()

    for (line in lines.drop(1)) {

        if (line.isBlank()) {
            continue
        }

        val data = line.split(",")

        val student = Student(
            id = data[0].toInt(),
            name = data[1],
            course = data[2],
            maths = data[3].toDouble(),
            english = data[4].toDouble(),
            programming = data[5].toDouble(),
            database = data[6].toDouble()
        )

        students.add(student)
    }

    return students
}