package main.com.yuliiakulyk.app.c.exceptions.homework;

import main.com.yuliiakulyk.app.e.streams.homework.CommonWordsFromFiles;

import java.io.*;
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

    public void writeToFile(File file) throws IOException {
        CommonWordsFromFiles.writeArrayToFile(students, file);
    }

    public static Group restoreFromFile(File file) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String studentString = "";
        Group group = new Group();
        String[] params;
        for (; (studentString = reader.readLine()) != null;) {
            params = studentString.split(",");
            try {
                group.addStudent(new Student(params[0], params[1], Integer.parseInt(params[2]), params[3], Boolean.parseBoolean(params[4]), params[5], params[6], params[7]));
            } catch (StudentGroupFullException e) {
                e.printStackTrace();
            }
        }
        reader.close();
        return group;
    }

    @Override
    public String toString() {
        String[] surnames = new String[students.length];
        for (int i = 0; i < students.length; i++) {
            if (students[i] != null) {
                surnames[i] = students[i].getSurname();
            }
        }
        return Arrays.toString(surnames);
    }
}
