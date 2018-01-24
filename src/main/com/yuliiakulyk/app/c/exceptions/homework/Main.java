package main.com.yuliiakulyk.app.c.exceptions.homework;

/**
 * Created by Yuliia Kulyk on 19.01.2018.
 */
public class Main {
    public static void main(String[] args) {
        Student student1 = new Student("Olya", "Izhyk", 18, "Kiev", false, "KPI", "RTF", "1");
        System.out.println(student1);

        Student student2 = new Student("Vasya", "Doronin", 18, "Kiev", true, "KPI", "RTF", "1");
        Student student3 = new Student("Masha", "Stepanyk", 18, "Kiev", false, "KPI", "RTF", "1");
        Student student4 = new Student("Sasha", "Konovalov", 18, "Kiev", true, "KPI", "RTF", "1");
        Student student5 = new Student("Yulia", "Samoylova", 18, "Kiev", false, "KPI", "RTF", "1");
        Student student6 = new Student("Bogdan", "Ivanov", 18, "Kiev", true, "KPI", "RTF", "1");
        Student student7 = new Student("Zhenya", "Kolosha", 18, "Kiev", true, "KPI", "RTF", "1");
        Student student8 = new Student("Katya", "Kovalska", 18, "Kiev", false, "KPI", "RTF", "1");
        Student student9 = new Student("Tanya", "Bosa", 18, "Kiev", false, "KPI", "RTF", "1");
        Student student10 = new Student("Andrey", "Zhidkov", 18, "Kiev", true, "KPI", "RTF", "1");
        Student student11 = new Student("Vova", "Sokolov", 18, "Kiev", true, "KPI", "RTF", "1");
        Student student12 = new Student("Vika", "Derkach", 18, "Kiev", false, "KPI", "RTF", "1");
        Student student13 = new Student("Zoya", "Sidorovich", 18, "Kiev", false, "KPI", "RTF", "1");

        Group group = new Group();
        try {
            group.addStudent(student1);
            group.addStudent(student2);
            group.addStudent(student3);
            group.addStudent(student4);
            group.addStudent(student5);
            group.addStudent(student6);
            group.addStudent(student7);
            group.addStudent(student8);
            group.addStudent(student9);
            group.addStudent(student10);
            group.addStudent(student11);
        } catch (StudentGroupFullException e) {
            //System.out.println(e.getMessage());
            e.printStackTrace();
        }

        System.out.println(group.searchBySurname("syd"));
        System.out.println(group.searchBySurname("doro"));
        System.out.println(group.searchBySurname("lov"));

        System.out.println("Group before removing Ivanov: ");
        System.out.println(group);
        try {
            group.removeStudent("Ivanov");
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Group after removing Ivanov: ");
        System.out.println(group);
    }

}
