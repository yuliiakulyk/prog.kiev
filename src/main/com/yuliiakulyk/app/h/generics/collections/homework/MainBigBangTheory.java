package main.com.yuliiakulyk.app.h.generics.collections.homework;

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
public class MainBigBangTheory {
    public static void main(String[] args) {
        System.out.println("After 2 glasses: ");
        BigBangTheory bigBangTheory1 = new BigBangTheory();
        bigBangTheory1.giveGlassesOfCola(2);
        System.out.println(bigBangTheory1);

        System.out.println();
        System.out.println("After 4 glasses: ");
        BigBangTheory bigBangTheory2 = new BigBangTheory();
        bigBangTheory2.giveGlassesOfCola(4);
        System.out.println(bigBangTheory2);
    }
}
