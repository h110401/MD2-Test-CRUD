package View;

import Controller.ClassroomController;
import Controller.StudentController;
import Model.Classroom;
import Model.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Classroom> classroomList = new ClassroomController().getClassroomList();
        List<Student> studentList = new StudentController().getStudentList();
        int choice = -1;
        while (choice != 10) {
            System.out.println("==============MENU=============");
            System.out.println("|  1. Show list classrooms    |");
            System.out.println("|  2. Create classroom        |");
            System.out.println("|  3. Edit classroom          |");
            System.out.println("|  4. Delete classroom        |");
            System.out.println("|  5. Show list students      |");
            System.out.println("|  6. Create student          |");
            System.out.println("|  7. Edit student            |");
            System.out.println("|  8. Delete student          |");
            System.out.println("|  9. Search student          |");
            System.out.println("| 10. EXIT                    |");
            System.out.println("===============================");
            choice = getIntegerInput("ENTER YOUR CHOICE");

            switch (choice) {
                case 1:
                    System.out.println("SHOW LIST CLASSROOM");
                    System.out.println(classroomList);
                    break;
                case 2:
                    System.out.println("CREATE CLASSROOM");
                    System.out.println("Enter classroom name:");
                    String name = sc.nextLine();
                    if (name.trim().isEmpty()) {
                        System.out.println("Can't enter blank");
                    } else if (new ClassroomController().contains(name)) {
                        System.out.println("Classroom already exists");
                    } else {
                        new ClassroomController().createClassroom(name);
                        System.out.println("CREATE SUCCESS");
                    }
                    break;
                case 3:
                    System.out.println("EDIT CLASSROOM");
                    int idEdit = getIntegerInput("Enter id:");
                    if (idEdit > classroomList.size()) {
                        System.out.println("INDEX OUT OF BOUNDS");
                        break;
                    }
                    System.out.println("Enter classroom name to edit:");
                    String editName = sc.nextLine();
                    if (editName.trim().isEmpty()) {
                        System.out.println("Can't enter blank");
                        break;
                    }
                    new ClassroomController().editClassroom(idEdit, editName);
                    System.out.println("EDIT SUCCESS");
                    break;
                case 4:
                    System.out.println("DELETE CLASSROOM");
                    int idDelete = getIntegerInput("Enter id:");

                    if (idDelete > classroomList.size()) {
                        System.out.println("INDEX OUT OF BOUNDS");
                        break;
                    }
                    new ClassroomController().delete(idDelete);
                    System.out.println("DELETE SUCCESS");
                    break;
                case 5:
                    System.out.println("SHOW LIST STUDENT");
                    System.out.println(studentList);
                    break;
                case 6:
                    System.out.println("CREATE STUDENT");
                    System.out.println("CHOOSE CLASSROOM");
                    for (int i = 0; i < classroomList.size(); i++) {
                        System.out.println((i + 1) + ". " + classroomList.get(i).getName());
                    }
                    int classId = getIntegerInput("Enter classroom id:");
                    System.out.println("Enter student name:");
                    String studentName = sc.nextLine();
                    if (studentName.trim().isEmpty()) {
                        System.out.println("Can't enter blank");
                        break;
                    }
                    new StudentController().createStudent(studentName, classId);
                    System.out.println("CREATE SUCCESS");
                    break;
                case 7:
                    System.out.println("EDIT STUDENT");
                    int idEditStudent = getIntegerInput("Enter student id:");
                    if (idEditStudent > studentList.size()) {
                        System.out.println("STUDENT INDEX OUT OF BOUNDS");
                        break;
                    }
                    System.out.println(new StudentController().getStudent(idEditStudent));
                    System.out.println("1. Edit name");
                    System.out.println("2. Edit classroom");
                    int editChoice = getIntegerInput("Enter choice: ");
                    switch (editChoice) {
                        case 1:
                            System.out.println("Enter student name to edit:");
                            String nameEdit = sc.nextLine();
                            if (nameEdit.trim().isEmpty()) {
                                System.out.println("Can't enter blank");
                                break;
                            }
                            new StudentController().editStudentName(idEditStudent, nameEdit);
                            break;
                        case 2:
                            System.out.println("CHOOSE CLASSROOM");
                            for (int i = 0; i < classroomList.size(); i++) {
                                System.out.println((i + 1) + ". " + classroomList.get(i).getName());
                            }
                            int studentClassroomEdit = getIntegerInput("Enter classroom id:");
                            new StudentController().editStudentClass(idEditStudent, studentClassroomEdit);
                            break;
                        default:
                            System.out.println("Invalid choice");
                    }
                    System.out.println("EDIT SUCCESS");
                    break;
                case 8:
                    System.out.println("DELETE STUDENT");
                    int idDeleteStudent = getIntegerInput("Enter student id");
                    if (idDeleteStudent > studentList.size()) {
                        System.out.println("INDEX OUT OF BOUNDS");
                        break;
                    }
                    new StudentController().deleteStudent(idDeleteStudent);
                    System.out.println("DELETE SUCCESS");
                    break;
                case 9:
                    System.out.println("SEARCH STUDENT");
                    System.out.println("1. By name");
                    System.out.println("2. By classroom");
                    int searchChoice = getIntegerInput("Enter choice:");
                    switch (searchChoice) {
                        case 1:
                            System.out.println("Enter student name:");
                            String nameSearch = sc.nextLine();
                            System.out.println(new StudentController().searchStudentByName(nameSearch));
                            break;
                        case 2:
                            System.out.println("CHOOSE CLASSROOM");
                            for (int i = 0; i < classroomList.size(); i++) {
                                System.out.println((i + 1) + ". " + classroomList.get(i).getName());
                            }
                            int classroomSearch = getIntegerInput("Enter classroom id:");
                            System.out.println(new StudentController().searchStudentByClassroom(classroomSearch));
                            break;
                        default:
                            System.out.println("Invalid choice");
                    }
                    break;
                default:
                    System.out.println("INVALID INPUT, PLEASE TRY AGAIN!!!");
            }

        }
    }

    private static int getIntegerInput(String s) {
        Scanner sc = new Scanner(System.in);
        String input = "";
        do {
            System.out.println(s);
            input = sc.nextLine();
            if (!input.matches("\\d+")) {
                System.out.println("INVALID INPUT");
            }
        } while (!input.matches("\\d+"));
        return Integer.parseInt(input);
    }
}
//VALIDATE EDIT INPUT