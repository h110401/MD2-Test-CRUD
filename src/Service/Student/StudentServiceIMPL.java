package Service.Student;

import Model.Classroom;
import Model.Student;
import Service.Class.ClassroomServiceIMPL;
import Service.MyList;

import java.util.ArrayList;
import java.util.List;

public class StudentServiceIMPL implements IStudentService {

    public static List<Student> studentList = (new ArrayList<Student>() {
        @Override
        public String toString() {
            String list = "Student List:\n";
            list += "=================================================\n";
            for (Student student : this) {
                list += student.toString() + "\n";
            }
            list += "=================================================\n";
            return list;
        }
    });

    static {
        studentList.add(new Student(1, "Hung", ClassroomServiceIMPL.classroomList.get(0)));
        studentList.add(new Student(2, "Chi", ClassroomServiceIMPL.classroomList.get(1)));
    }

    @Override
    public List<Student> finAll() {
        return studentList;
    }

    @Override
    public void create(Student student) {
        studentList.add(student);
    }

    @Override
    public void edit(Student student) {
        studentList.get(student.getId() - 1).setName(student.getName());
        studentList.get(student.getId() - 1).setClassroom(student.getClassroom());
    }

    @Override
    public void delete(int index) {
        studentList.remove(index);
    }

}
