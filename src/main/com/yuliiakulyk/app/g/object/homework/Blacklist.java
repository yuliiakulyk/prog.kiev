package main.com.yuliiakulyk.app.g.object.homework;

import java.util.Set;
import java.util.TreeSet;

/**
 * Created by Yuliia Kulyk on 10.02.2018.
 */
public class Blacklist {
    private Set<String> classes;

    public Blacklist(Set classes) {
        this.classes = classes;
    }

    public Blacklist() {
        this.classes = new TreeSet<String>();
    }

    public Set<String> getClasses() {
        return classes;
    }

    public void setClasses(Set<String> classes) {
        this.classes = classes;
    }

    public void addClass(Class c) {
        this.classes.add(c.getName());
    }

    public void addClass(String className) {
        this.classes.add(className);
    }

    public boolean isAllowed(Object o) {
        if (this.classes.contains(o.getClass().getName())) {
            return false;
        }
        return true;
    }
}
