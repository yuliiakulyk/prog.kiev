package main.com.yuliiakulyk.app.h.generics.collections;

/**
 * Created by Yuliia Kulyk on 08.02.2018.
 */
public class SomeClass <T> {
    private T someField;

    public SomeClass(T someField) {
        this.someField = someField;
    }

    public T getSomeField() {
        return someField;
    }

    public void setSomeField(T someField) {
        this.someField = someField;
    }

    @Override
    public String toString() {
        return "SomeClass{" +
                "someField=" + someField +
                '}';
    }
}
