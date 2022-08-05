package Service.Class;

import Model.Classroom;
import Model.Student;

import java.util.ArrayList;
import java.util.List;

public class ClassroomServiceIMPL implements IClassroomService {

    public static List<Classroom> classroomList = new ArrayList<Classroom>() {
        @Override
        public String toString() {
            String list = "Classroom List:\n";
            list += "==================================\n";
            for (Classroom classroom : this) {
                list += classroom.toString() + "\n";
            }
            list += "==================================\n";
            return list;
        }
    };

    static {
        classroomList.add(new Classroom(1, "JV062022"));
        classroomList.add(new Classroom(2, "JS072022"));
    }


    @Override
    public List<Classroom> finAll() {
        return classroomList;
    }

    @Override
    public void create(Classroom classroom) {
        classroomList.add(classroom);
    }

    @Override
    public void edit(Classroom classroom) {
        classroomList.get(classroom.getId() - 1).setName(classroom.getName());
    }

    public void delete(int index) {
        classroomList.remove(index);
    }

}
