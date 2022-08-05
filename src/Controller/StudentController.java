package Controller;

import Model.Classroom;
import Model.Student;
import Service.Class.ClassroomServiceIMPL;
import Service.Student.IStudentService;
import Service.Student.StudentServiceIMPL;

import java.util.List;

public class StudentController {

    StudentServiceIMPL studentService = new StudentServiceIMPL();

    public List<Student> getStudentList() {
        return StudentServiceIMPL.studentList;
    }

    public Student getStudent(int id) {
        return getStudentList().get(id - 1);
    }

    public void createStudent(String studentName, int classroomId) {
        studentService.create(
                new Student(
                        StudentServiceIMPL.studentList.size() + 1,
                        studentName,
                        new Classroom(classroomId, ClassroomServiceIMPL.classroomList.get(classroomId - 1).getName()
                        )
                )
        );
    }

    public void editStudentName(int id, String name) {
        studentService.edit(
                new Student(
                        id,
                        name,
                        StudentServiceIMPL.studentList.get(id - 1).getClassroom()
                )
        );
    }

    public void editStudentClass(int id, int classroomId) {
        studentService.edit(
                new Student(
                        id,
                        StudentServiceIMPL.studentList.get(id - 1).getName(),
                        ClassroomServiceIMPL.classroomList.get(classroomId - 1)
                )
        );
    }

    public void deleteStudent(int id) {
        studentService.delete(id - 1);
        updateList(id - 1);
    }

    private void updateList(int index) {
        for (int i = index; i < StudentServiceIMPL.studentList.size(); i++) {
            StudentServiceIMPL.studentList.get(i).setId(i + 1);
        }
    }
}
