package main.com.yuliiakulyk.app.h.generics.collections.homework;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yuliia Kulyk on 10.02.2018.
 Шелдон, Леонард, Воловиц, Кутрапалли и Пенни стоят в очереди
 за «двойной колой». Как только человек выпьет такой колы он
 раздваивается и оба становятся в конец очереди, что бы выпить еще
 стаканчик. Напишите программу которая выведет на экран
 состояние очереди в зависимости от того сколько стаканов колы
 выдал аппарат с чудесным напитком. Например если было выдано
 только два стакана, то очередь выглядит как:
 [Volovitc, Kutrapalli, Penny,Sheldon,Sheldon,Leonard,Leonard]
 */
public class BigBangTheory {
    private List<String> queue;

    public BigBangTheory() {
        this.queue = new ArrayList<String>();
        queue.add("Sheldon");
        queue.add("Leonard");
        queue.add("Volovitc");
        queue.add("Kutrapalli");
        queue.add("Penny");
    }

    public List<String> getQueue() {
        return queue;
    }

    public void giveGlassesOfCola(int numberOfGlasses) {
        String theOneWhoDrinks;
        for (int i = 0; i < numberOfGlasses; i++) {
            theOneWhoDrinks = this.queue.get(0);
            this.queue.remove(0);
            this.queue.add(theOneWhoDrinks);
            this.queue.add(theOneWhoDrinks);
        }
    }

    @Override
    public String toString() {
        return "BigBangTheory{" +
                "queue=" + queue +
                '}';
    }
}
