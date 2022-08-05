package Controller;

import Model.Classroom;
import Service.Class.ClassroomServiceIMPL;

import java.util.List;

public class ClassroomController {

    ClassroomServiceIMPL classroomService = new ClassroomServiceIMPL();

    public List<Classroom> getClassroomList() {
        return ClassroomServiceIMPL.classroomList;
    }

    public void createClassroom(String classroomName) {
        classroomService.create(new Classroom(ClassroomServiceIMPL.classroomList.size() + 1, classroomName));
    }

    public void editClassroom(int id, String classroomName) {
        classroomService.edit(new Classroom(id, classroomName));
    }

    public void delete(int id) {
        classroomService.delete(id - 1);
        updateList(id - 1);
    }

    private void updateList(int index) {
        for (int i = 0; i < ClassroomServiceIMPL.classroomList.size(); i++) {
            ClassroomServiceIMPL.classroomList.get(i).setId(i + 1);
        }
    }

    public boolean contains(String name) {
        for (Classroom classroom : classroomService.finAll()) {
            if (classroom.getName().equals(name)) return true;
        }
        return false;
    }
}
