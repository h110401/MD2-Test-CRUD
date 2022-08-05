package Service;

import Model.Student;

import java.util.ArrayList;

public class MyList<E> extends ArrayList<E> {
    @Override
    public String toString() {
        String list = "Student List:\n";
        list += "=================================================\n";
        for (E element : this) {
            list += element.toString() + "\n";
        }
        list += "=================================================\n";
        return list;
    }
}
