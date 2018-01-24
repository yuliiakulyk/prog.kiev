package main.com.yuliiakulyk.app.c.exceptions.homework;

/**
 * Created by Yuliia Kulyk on 24.01.2018.
 */
public class StudentGroupFullException extends Exception {
    @Override
    public String getMessage() {
        return "Student group is full.";
    }
}
