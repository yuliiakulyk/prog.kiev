package main.com.yuliiakulyk.app.c.exceptions.homework;

import main.com.yuliiakulyk.app.e.streams.homework.CommonWordsFromFiles;
import main.com.yuliiakulyk.app.g.object.ObjectFileWorker;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by Yuliia Kulyk on 19.01.2018.
 *
 * Создайте класс группа — который содержит массив из 10
 объектов класса студент. Реализуйте методы добавления,
 удаления студента и метод поиска студента по фамилии. В
 случае попытки добавления 11 студента создайте
 собственное исключение и обработайте его. Определите
 метод toString() для группы так, что бы он выводил список
 студентов в алфавитном порядке.
 * Усовершенствуйте класс Group добавив возможность
 интерактивного добавления объекта.
 * Усовершенствуйте класс описывающий группу студентов
 добавив возможность сохранения группы в файл.
 * Реализовать обратный процесс — т.е. считать данные о
 группе из файла и на их основе создать объект типа группа.
 * Используя стандартный методы сериализации создайте мини базу
 данных для работы с группами студентов (возможность записи и чтения
 базы из файла по запросу пользователя).
 */
public class Group implements Serializable {
    private Student[] students;

    public Group() {
        this.students = new Student[10];
    }

    public Student[] getStudents() {
        return students;
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
        if (file == null) {
            throw new IllegalArgumentException("Pointer to file is null!");
        }
        CommonWordsFromFiles.writeArrayToFile(students, file);
    }

    public static Group restoreFromFile(File file) throws IOException {
        if (file == null) {
            throw new IllegalArgumentException("Pointer to file is null!");
        }
        String studentString;
        Group group = new Group();
        String[] params;
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            for (; (studentString = reader.readLine()) != null;) {
                params = studentString.split(",");
                try {
                    group.addStudent(new Student(params[0], params[1], Integer.parseInt(params[2]), params[3], Boolean.parseBoolean(params[4]), params[5], params[6], params[7]));
                } catch (StudentGroupFullException e) {
                    e.printStackTrace();
                }
            }
        }
        return group;
    }

    public void writeToFileSerialize(File file) throws IOException {
        if (file == null) {
            throw new IllegalArgumentException("File pointer is null");
        }
        ObjectFileWorker.saveObjectToFile(file, this);
    }

    public static Group readFromFileSerialize(File file) throws IOException {
        if (file == null) {
            throw new IllegalArgumentException("File pointer is null");
        }
        Group result = null;
        return (Group) ObjectFileWorker.loadObjectFromFile(file);
    }

    @Override
    public String toString() {
        List<Student> group = new ArrayList<>();
        for (int i = 0; i < students.length; i++) {
            if (students[i] != null) {
                group.add(students[i]);
            }
        }
        Collections.sort(group);
        String[] surnames = new String[group.size()];
        for (int i = 0; i < surnames.length; i++) {
            surnames[i] = group.get(i).getSurname();
        }
        return Arrays.toString(surnames);
    }
}
