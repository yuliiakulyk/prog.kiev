package main.com.yuliiakulyk.app.g.object.homework;

import main.com.yuliiakulyk.app.c.exceptions.homework.Group;
import main.com.yuliiakulyk.app.c.exceptions.homework.Student;
import main.com.yuliiakulyk.app.c.exceptions.homework.StudentGroupFullException;
import main.com.yuliiakulyk.app.g.object.ObjectFileWorker;

import java.io.*;

/**
 * Created by Yuliia Kulyk on 07.02.2018.
 */
public class MainGroupSerialization {
    public static void main(String[] args) {

        Group group = new Group();
        try {
            group.addStudent(new Student("Olya", "Izhyk", 18, "Kiev", false, "KPI", "RTF", "1"));
            group.addStudent(new Student("Vasya", "Doronin", 18, "Kiev", true, "KPI", "RTF", "1"));
            group.addStudent(new Student("Masha", "Stepanyk", 18, "Kiev", false, "KPI", "TEF", "1"));
            group.addStudent(new Student("Sasha", "Konovalov", 18, "Kiev", true, "KPI", "FMM", "1"));
            group.addStudent(new Student("Yulia", "Samoylova", 18, "Kiev", false, "KPI", "Biotech", "1"));
            group.addStudent(new Student("Bogdan", "Ivanov", 18, "Kiev", true, "KPI", "FIOT", "1"));
        } catch (StudentGroupFullException e) {
            e.printStackTrace();
        }
        try {
            group.writeToFileSerialize(new File("src\\main\\com\\yuliiakulyk\\app\\g\\object\\homework\\group.dat"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        Group restoredGroup = null;
        try {
            restoredGroup = Group.readFromFileSerialize(new File("src\\main\\com\\yuliiakulyk\\app\\g\\object\\homework\\group.dat"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(restoredGroup);
        System.out.println("Students info:");
        for (Student student: restoredGroup.getStudents()) {
            System.out.println(student);
        }
    }
}