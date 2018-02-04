package main.com.yuliiakulyk.app.c.exceptions.homework;

/**
 * Created by Yuliia Kulyk on 19.01.2018.
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
        UNIVERSITY, FACULTY, GROUP;
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
}
