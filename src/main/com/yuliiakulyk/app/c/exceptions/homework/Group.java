package main.com.yuliiakulyk.app.c.exceptions.homework;

import java.util.Arrays;

/**
 * Created by Yuliia Kulyk on 19.01.2018.
 */
public class Group {
    private Student[] students;

    public Group() {
        this.students = new Student[10];
    }

    public void addStudent(Student student) throws StudentGroupFullException {
        boolean added = false;
        for (int i = 0; i < students.length; i++) {
            if (students[i] == null) {
                students[i] = student;
                added = true;
                break;
            }
        }
        if (added == false) {
            throw new StudentGroupFullException();
        }
    }

    public void removeStudent(String surname) throws Exception {
        if (searchBySurname(surname) == null) {
            throw new Exception("Student with this surname doesn't exist in this group, impossible to remove the student.");
        } else {
            int i = Arrays.asList(students).indexOf(searchBySurname(surname));
            students[i] = null;
        }
    }

    public Student searchBySurname(String query) {
        for (Student student:
                students) {
            if (student != null && student.getSurname().toLowerCase().contains(query.toLowerCase())) {
                return student;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        String[] surnames = new String[students.length];
        for (int i = 0; i < students.length; i++) {
            if (students[i] != null) {
                surnames[i] = students[i].getSurname();
            }
        }
        return "Group{" +
                "students=" + Arrays.toString(surnames) +
                '}';
    }
}
