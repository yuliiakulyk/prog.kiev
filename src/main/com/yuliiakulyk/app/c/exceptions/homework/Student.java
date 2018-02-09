package main.com.yuliiakulyk.app.c.exceptions.homework;

import main.com.yuliiakulyk.app.g.object.ObjectFileWorker;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by Yuliia Kulyk on 19.01.2018.
 *
 * Создайте класс описывающий человека (создайте метод
 выводящий информацию о человеке)
 На его основе создайте класс студент (переопределите
 метод вывода информации)
 Реализуйте возможность сортировки списка студентов
 по фамилии.
 Реализуйте возможность сортировки по параметру
 (Фамилия, успеваемость и т. д.).
 */
public class Student extends Human implements Comparable {
    private String university;
    private String faculty;
    private String group;

    public Student(String name, String surname, int age, String address, boolean isMale, String university, String faculty, String group) {
        super(name, surname, age, address, isMale);
        this.university = university;
        this.faculty = faculty;
        this.group = group;
    }

    public Student() {
        super();
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    @Override
    public String toString() {
        return super.toString() +
                "," + university +
                "," + faculty +
                "," + group;
    }

    public enum StudentProperties {
        UNIVERSITY, FACULTY, GROUP, NAME, SURNAME, AGE, ADDRESS, GENDER
    }

    public static void sort(Student[] array, StudentProperties property, boolean isLowToHigh) {
        Arrays.sort(array, getStudentComparator(property, isLowToHigh));
    }

    private static void reverseArray(Student[] array) {
        Student temp;
        for (int i = 0; i < array.length/2; i++) {
            temp = array[i];
            array[i] = array[array.length-1-i];
            array[array.length-1-i] = temp;
        }
    }

    private static Comparator<String> getStringComparator() {
        return new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                if (s1 == null && s2 == null) {
                    return 0;
                }
                if (s1 == null) {
                    return -1;
                }
                if (s2 == null) {
                    return 1;
                }
                return s1.compareTo(s2);
            }
        };
    }

    public static Comparator<Student> getStudentComparator(StudentProperties property, boolean isAscendingOrder) {
        return new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                int multiplier = 1;
                if (!isAscendingOrder) {
                    multiplier = -1;
                }
                if (s1 == null && s2 == null) {
                    return 0;
                }
                if (s1 == null) {
                    return -1 * multiplier;
                }
                if (s2 == null) {
                    return 1 * multiplier;
                }
                return compareNeededProperties(property, s1, s2) * multiplier;
            }

            public int compareNeededProperties(StudentProperties properties, Student s1, Student s2) {
                switch (properties) {
                    case FACULTY:
                        return getStringComparator().compare(s1.getFaculty(), s2.getFaculty());
                    case UNIVERSITY:
                        return getStringComparator().compare(s1.getUniversity(), s2.getUniversity());
                    case GROUP:
                        return getStringComparator().compare(s1.getGroup(), s2.getGroup());
                    case NAME:
                        return getStringComparator().compare(s1.getName(), s2.getName());
                    case SURNAME:
                        return getStringComparator().compare(s1.getSurname(), s2.getSurname());
                    case AGE:
                        return new Integer(s1.getAge()).compareTo(new Integer(s2.getAge()));
                    case ADDRESS:
                        return getStringComparator().compare(s1.getAddress(), s2.getAddress());
                    case GENDER:
                        return new Boolean(s1.isMale()).compareTo(new Boolean(s2.isMale()));
                    default:
                        return 0;
                }
            }
        };
    }

    @Override
    public int compareTo(Object o) {
        if (o == null) {
            return 1;
        }
        Student anotherStudent = (Student) o;
        if (this.getSurname().compareTo(anotherStudent.getSurname()) > 0) {
            return 1;
        } else {
            return -1;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Student student = (Student) o;

        if (university != null ? !university.equals(student.university) : student.university != null) return false;
        if (faculty != null ? !faculty.equals(student.faculty) : student.faculty != null) return false;
        return group != null ? group.equals(student.group) : student.group == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (university != null ? university.hashCode() : 0);
        result = 31 * result + (faculty != null ? faculty.hashCode() : 0);
        result = 31 * result + (group != null ? group.hashCode() : 0);
        return result;
    }
}
