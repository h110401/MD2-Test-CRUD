package Model;

public class Student {
    private int id;
    private String name;
    private Classroom classroom;

    public Student() {
    }

    public Student(int id, String name, Classroom classroom) {
        this.id = id;
        this.name = name;
        this.classroom = classroom;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Classroom getClassroom() {
        return classroom;
    }

    public void setClassroom(Classroom classroom) {
        this.classroom = classroom;
    }

    @Override
    public String toString() {
        return String.format("| ID: %-3d | Name: %-6s | Classroom: %s  |", id, name, classroom.getName());
    }
}
