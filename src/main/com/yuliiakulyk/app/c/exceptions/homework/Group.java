package main.com.yuliiakulyk.app.c.exceptions.homework;

import main.com.yuliiakulyk.app.e.streams.homework.CommonWordsFromFiles;
import main.com.yuliiakulyk.app.g.object.ObjectFileWorker;

import java.io.*;
import java.util.*;

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
 Модифицируйте класс группа для более удобных методов работы
 с динамическими массивами.
 */
public class Group implements Serializable {
    //private Student[] students;
    private SortedSet<Student> students;
    private int maxSize;

    public Group() {
        this.students = new TreeSet<>(Student.getStudentComparator(Student.StudentProperties.SURNAME, true));
        this.maxSize = 10;
    }

    public Group(int size) {
        this.students = new TreeSet<>(Student.getStudentComparator(Student.StudentProperties.SURNAME, true));
        this.maxSize = size;
    }

    public SortedSet<Student> getStudents() {
        return students;
    }

    public int getMaxSize() {
        return maxSize;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }

    public void addStudent(Student student) throws StudentGroupFullException {
        if (student == null) {
            throw new IllegalArgumentException("Parameter is null");
        } else if (this.getStudents().size() >= this.maxSize) {
            throw new StudentGroupFullException();
        } else {
            students.add(student);
        }
    }

    public void removeStudent(String surname) throws Exception {
        if (searchBySurname(surname) == null) {
            throw new Exception("Student with this surname doesn't exist in this group, impossible to remove the student.");
        } else {
            students.remove(searchBySurname(surname));
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
        CommonWordsFromFiles.writeArrayToFile(students.toArray(), file);
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
        StringBuilder builder = new StringBuilder("Group students: ");
        Iterator<Student> iterator = students.iterator();
        for(; iterator.hasNext(); ) {
            builder.append(iterator.next().getSurname() + ",");
        }
        try {
            builder.deleteCharAt(builder.lastIndexOf(","));
        } catch (StringIndexOutOfBoundsException e) {

        }
        return builder.toString();
    }
}
