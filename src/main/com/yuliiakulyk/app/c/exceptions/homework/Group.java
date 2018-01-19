package main.com.yuliiakulyk.app.c.exceptions.homework;

/**
 * Created by Yuliia Kulyk on 19.01.2018.
 */
public class Group {
    private Student[] students;

    public Group() {
        this.students = new Student[10];
    }

    public void addStudent(Student student) throws Exception {
        boolean added = false;
        for (int i = 0; i < students.length; i++) {
            if (students[i] == null) {
                students[i] = student;
                added = true;
                break;
            }
        }
        if (added = false) {
            throw new Exception("Group is full!");
        }
    }


}
