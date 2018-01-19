package main.com.yuliiakulyk.app.c.exceptions.homework;

/**
 * Created by Yuliia Kulyk on 19.01.2018.
 */
public class Student extends Human {
    private String university;
    private String faculty;
    private String group;

    public Student(String name, int age, String address, boolean isMale, String university, String faculty, String group) {
        super(name, age, address, isMale);
        this.university = university;
        this.faculty = faculty;
        this.group = group;
    }

    public Student() {
        super();
    }

    @Override
    public String toString() {
        return "Student{" +
                super.toString() +
                ", university='" + university + '\'' +
                ", faculty='" + faculty + '\'' +
                ", group='" + group + '\'' +
                '}';
    }
}
